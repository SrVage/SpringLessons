package com.example.Lesson_2.services;

import com.example.Lesson_2.entities.Student;
import com.example.Lesson_2.events.AddStudentEvent;
import com.example.Lesson_2.events.DeleteStudentEvent;
import com.example.Lesson_2.events.ErrorEvent;
import com.example.Lesson_2.events.Event;
import com.example.Lesson_2.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class StudentServiceImpl {
    private final StudentsRepository studentsRepository;
    private final ApplicationEventPublisher eventPublisher;

    @ShellMethod
    public void add(String firstName, String secondName, int age){
        Student student = new Student(firstName, secondName, age);
        var saveStudent = studentsRepository.saveStudent(student);
        eventPublisher.publishEvent(new AddStudentEvent(this, saveStudent.toString()));
    }

    @ShellMethod
    public void delete(int id){
        var deleteStudent = studentsRepository.deleteStudent(id);
        if (deleteStudent){
            eventPublisher.publishEvent(new DeleteStudentEvent(this, String.valueOf(id)));
        } else{
            eventPublisher.publishEvent(new ErrorEvent(this, "No student with id: " + id));
        }
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
