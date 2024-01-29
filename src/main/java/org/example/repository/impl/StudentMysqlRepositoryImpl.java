package org.example.repository.impl;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.example.entity.Student;
import org.example.repository.StudentRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentMysqlRepositoryImpl implements StudentRepository {

    private static final StudentMysqlRepositoryImpl INSTANCE = new StudentMysqlRepositoryImpl();

    private StudentMysqlRepositoryImpl() {
    }

    public static StudentMysqlRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addStudent(Student student) {
        try {
            Connection conn = getConnection();

            String query = """
                        INSERT INTO student (name, surname, birthdate) 
                        VALUES (?, ?, ?);
                    """;
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, student.getName());
            stm.setString(2, student.getSurname());
            stm.setDate(3, Date.valueOf(student.getBirthDate()) );

            stm.executeUpdate();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {

        try {
            Connection conn = getConnection();

            String query = "SELECT id, name, surname, birthdate FROM student";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Date birthdate = resultSet.getDate("birthdate");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setSurname(surname);
                student.setBirthDate(birthdate.toLocalDate());

                students.add(student);
            }

            conn.close();
            return students;

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://allinone.cn5daduvgses.us-east-1.rds.amazonaws.com:3306/vs_learning";
            String username = "admin";
            String password = "Admin1234";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("exception occurred");
        }
    }
}
