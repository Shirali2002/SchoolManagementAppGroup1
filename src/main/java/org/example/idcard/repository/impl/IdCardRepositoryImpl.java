package org.example.idcard.repository.impl;

import org.example.idcard.model.entity.IdCard;
import org.example.idcard.repository.IdCardRepository;
import org.example.student.entity.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdCardRepositoryImpl implements IdCardRepository {

    private static final IdCardRepositoryImpl INSTANCE = new IdCardRepositoryImpl();

    private IdCardRepositoryImpl() {
    }

    public static IdCardRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<IdCard> getAll() {

        try {
            Connection conn = getConnection();

            String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serial_number FROM vs_learning.id_card i;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<IdCard> idCards = new ArrayList<>();

            while (resultSet.next()) {
                IdCard idCard = IdCard.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .age(resultSet.getInt("age"))
                        .finCode(resultSet.getString("fin_code"))
                        .series(resultSet.getString("series"))
                        .serialNumber(resultSet.getString("serial_number"))
                        .build();

                idCards.add(idCard);
            }

            conn.close();
            return idCards;

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public IdCard getById(Long id) {

        try {
            Connection conn = getConnection();

            String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serial_number FROM vs_learning.id_card i WHERE i.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            }
            IdCard idCard = IdCard.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .finCode(resultSet.getString("fin_code"))
                    .series(resultSet.getString("series"))
                    .serialNumber(resultSet.getString("serial_number"))
                    .build();

            conn.close();
            return idCard;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(IdCard idCard) {

        try {
            Connection conn = getConnection();

            String query = "INSERT INTO vs_learning.id_card (name, surname, age, fin_code, series, serial_number) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, idCard.getName());
            preparedStatement.setString(2, idCard.getSurname());
            preparedStatement.setInt(3, idCard.getAge());
            preparedStatement.setString(4, idCard.getFinCode());
            preparedStatement.setString(5, idCard.getSeries());
            preparedStatement.setString(6, idCard.getSerialNumber());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(IdCard idCard) {

        try {
            Connection conn = getConnection();

            String query = "UPDATE vs_learning.id_card i SET i.name = ?, i.surname = ?, i.age = ?, i.fin_code = ?, series = ?, i.serial_number = ? WHERE i.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, idCard.getName());
            preparedStatement.setString(2, idCard.getSurname());
            preparedStatement.setInt(3, idCard.getAge());
            preparedStatement.setString(4, idCard.getFinCode());
            preparedStatement.setString(5, idCard.getSeries());
            preparedStatement.setString(6, idCard.getSerialNumber());
            preparedStatement.setLong(7, idCard.getId());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(Long id) {

        try {
            Connection conn = getConnection();

            String query = "DELETE FROM vs_learning.id_card i WHERE i.id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
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
