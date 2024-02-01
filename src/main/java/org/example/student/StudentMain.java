package org.example.student;

import org.example.student.controller.StudentController;
import org.example.student.dto.request.AddStudentRequest;
import org.example.student.dto.response.GetStudentResponse;
import org.example.student.util.RequestBuilderUtil;

import java.util.List;
import java.util.Scanner;

public class StudentMain {

    private static final StudentController studentController = StudentController.getInstance();

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("""
                --------------------------------------------
                Choose your process:
                1. add Student
                2. get all students""");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                getAllStudents();
                break;
            default:
                defaultSwitchCase();
        }
    }

    private static void addStudent() {
        AddStudentRequest addStudentRequest = RequestBuilderUtil.addStudent();
        studentController.addStudent(addStudentRequest);
    }

    private static void getAllStudents() {
        List<GetStudentResponse> students = studentController.getAllStudents();
        for (GetStudentResponse student : students) {
            System.out.println(student.toString());
        }
    }

    private static void defaultSwitchCase() {
        System.out.println("Your choice is not OK for us. Please choose again");
        menu();
    }

}