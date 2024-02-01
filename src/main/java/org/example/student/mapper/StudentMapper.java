package org.example.student.mapper;

import org.example.student.dto.request.AddStudentRequest;
import org.example.student.dto.response.GetStudentResponse;
import org.example.student.entity.Student;
import org.example.student.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    private static final StudentMapper INSTANCE = new StudentMapper();

    private StudentMapper() {}

    public static StudentMapper getInstance() {
        return INSTANCE;
    }

    public Student toStudent(AddStudentRequest addStudentRequest) {
        Student student = new Student();
        student.setName(addStudentRequest.getName());
        student.setSurname(addStudentRequest.getSurname());
        student.setBirthDate(
                DateUtil.toLocalDate(
                        addStudentRequest.getBirthDate()
                )
        );

        return student;
    }

    public List<GetStudentResponse> toGetStudentResponseList(List<Student> studentList) {
        List<GetStudentResponse> getStudentResponseList = new ArrayList<>();

        for (Student student: studentList) {
            GetStudentResponse getStudentResponse = new GetStudentResponse();
            getStudentResponse.setId(student.getId());
            getStudentResponse.setName(student.getName());
            getStudentResponse.setSurname(student.getSurname());
            getStudentResponse.setBirthDate(
                    DateUtil.toString(
                            student.getBirthDate()
                    )
            );
            getStudentResponseList.add(getStudentResponse);
        }

        return getStudentResponseList;
    }

}
