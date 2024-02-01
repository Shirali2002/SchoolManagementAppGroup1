package org.example.student.service;

import org.example.student.dto.request.AddStudentRequest;
import org.example.student.dto.response.GetStudentResponse;

import java.util.List;

public interface StudentService {

    void addStudent(AddStudentRequest request);
    List<GetStudentResponse> getAllStudents();

}
