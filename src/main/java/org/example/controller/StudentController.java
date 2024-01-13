package org.example.controller;

import org.example.dto.request.AddStudentRequest;
import org.example.dto.response.GetStudentResponse;
import org.example.service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public void addStudent(AddStudentRequest request) {
        studentService.addStudent(request);
    }

    public List<GetStudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

}
