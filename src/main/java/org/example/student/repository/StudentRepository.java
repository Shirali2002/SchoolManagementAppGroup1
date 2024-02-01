package org.example.student.repository;

import org.example.student.entity.Student;

import java.util.List;

public interface StudentRepository {
    // A -> B

    void addStudent(Student student);
    List<Student> getAllStudents();

}
