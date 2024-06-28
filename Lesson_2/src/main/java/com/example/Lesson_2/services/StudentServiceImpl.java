package com.example.Lesson_2.services;

import com.example.Lesson_2.entities.Student;
import com.example.Lesson_2.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentsRepository studentsRepository;

    @ShellMethod
    public String add(String firstName, String secondName, int age){
        Student student = new Student(firstName, secondName, age);
        studentsRepository.saveStudent(student);
        return "Added";
    }
}
