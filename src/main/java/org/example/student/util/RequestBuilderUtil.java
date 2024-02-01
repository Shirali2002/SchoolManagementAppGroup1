package org.example.student.util;

import org.example.student.dto.request.AddStudentRequest;

import java.util.Scanner;

public final class RequestBuilderUtil {
    private RequestBuilderUtil() {
    }

    public static AddStudentRequest addStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter student name:");
        String name = sc.nextLine();

        System.out.println("please enter student surname:");
        String surname = sc.nextLine();

        System.out.println("please enter student birhtdate (date format is -> day/monthNumber/year):");
        String birthdate = sc.nextLine();

        AddStudentRequest addStudentRequest = new AddStudentRequest();
        addStudentRequest.setName(name);
        addStudentRequest.setSurname(surname);
        addStudentRequest.setBirthDate(birthdate);

        return addStudentRequest;
    }

}
