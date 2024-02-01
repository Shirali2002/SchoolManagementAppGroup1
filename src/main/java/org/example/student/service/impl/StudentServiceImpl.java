package org.example.student.service.impl;

import org.example.student.dto.request.AddStudentRequest;
import org.example.student.dto.response.GetStudentResponse;
import org.example.student.entity.Student;
import org.example.student.mapper.StudentMapper;
import org.example.student.repository.StudentRepository;
import org.example.student.repository.impl.StudentMysqlRepositoryImpl;
import org.example.student.service.StudentService;
import org.example.student.util.IdGeneratorUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final StudentServiceImpl INSTANCE = new StudentServiceImpl();
    private final StudentRepository studentRepository = StudentMysqlRepositoryImpl.getInstance();
//    private final StudentRepository studentRepository = StudentMapRepositoryImpl.getInstance();
    private final StudentMapper studentMapper = StudentMapper.getInstance();

    private StudentServiceImpl() {}

    public static StudentServiceImpl getInstance() {
        return INSTANCE;
    }

    public void addStudent(AddStudentRequest request) {
        Student student = studentMapper.toStudent(request);
        student.setId(IdGeneratorUtil.getNewStudentId());

        studentRepository.addStudent(student);
    }

    public List<GetStudentResponse> getAllStudents() {
        List<Student> students = studentRepository.getAllStudents();
        return studentMapper.toGetStudentResponseList(students);
    }
}
