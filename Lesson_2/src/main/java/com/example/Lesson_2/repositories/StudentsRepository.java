package com.example.Lesson_2.repositories;

import com.example.Lesson_2.entities.Student;

import java.util.Set;

public interface StudentsRepository {
    Set<Student> getStudents();

    boolean saveStudent(Student student);

    boolean deleteStudent(int id);

    void clear();
}
