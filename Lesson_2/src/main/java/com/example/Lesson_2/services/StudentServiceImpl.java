package com.example.Lesson_2.services;

import com.example.Lesson_2.entities.Student;
import com.example.Lesson_2.events.Event;
import com.example.Lesson_2.events.EventHandler;
import com.example.Lesson_2.events.EventQueue;
import com.example.Lesson_2.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentsRepository studentsRepository;
    private final EventQueue eventQueue;

    @ShellMethod
    public String add(String firstName, String secondName, int age){
        Student student = new Student(firstName, secondName, age);
        var saveStudent = studentsRepository.saveStudent(student);
        eventQueue.addEvent(new Event("Added: " + saveStudent));
        return "Added";
    }

    @ShellMethod
    public String delete(int id){
        studentsRepository.deleteStudent(id);
        return "Deleted";
    }

    @ShellMethod (key = "show all")
    public String getAll(){
        var students = studentsRepository.getStudents();
        StringBuilder builder = new StringBuilder();
        for(var student:students){
            builder.append(student)
                    .append('\n');
        }
        return builder.toString();
    }

    @ShellMethod(key = "clear all")
    public String clearAll(){
        studentsRepository.clear();
        return "All students were cleared";
    }
}
