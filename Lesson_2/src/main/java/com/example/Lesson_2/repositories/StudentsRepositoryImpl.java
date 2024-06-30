package com.example.Lesson_2.repositories;

import com.example.Lesson_2.entities.Student;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class StudentsRepositoryImpl implements StudentsRepository{
    private final Set<Student> students = new HashSet<>();
    private int maxNumber = 0;

    @Override
    public Set<Student> getStudents(){
        return students;
    }

    @Override
    public boolean saveStudent(Student student){
        student.setId(maxNumber++);
        System.out.println(student);
        return students.add(student);
    }

    @Override
    public boolean deleteStudent(int id){
        var deleteStudent = students.stream().filter(item->item.getId() == id)
                .findFirst().orElseThrow(()->new NoSuchElementException("Нет студента с таким id"));
        return students.remove(deleteStudent);
    }

    @Override
    public void clear(){
        students.clear();
    }

}
