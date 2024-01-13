package org.example.repository;

import org.example.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    private static final Map<Long, Student> students = new HashMap<>(); // our database for student

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

}
