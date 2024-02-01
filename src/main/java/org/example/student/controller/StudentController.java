package org.example.student.controller;

import org.example.student.dto.request.AddStudentRequest;
import org.example.student.dto.response.GetStudentResponse;
import org.example.student.service.StudentService;
import org.example.student.service.impl.StudentServiceImpl;

import java.util.List;

public class StudentController {

    private static final StudentController INSTANCE = new StudentController();
    private final StudentService studentService = StudentServiceImpl.getInstance();

    private StudentController() {}

    public static StudentController getInstance() {
        return INSTANCE;
    }

    public void addStudent(AddStudentRequest request) {
        studentService.addStudent(request);
    }

    public List<GetStudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

}
