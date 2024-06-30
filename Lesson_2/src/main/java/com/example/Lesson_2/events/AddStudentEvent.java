package com.example.Lesson_2.events;

public class AddStudentEvent extends Event{

    public AddStudentEvent(Object source, String payload) {
        super(source, "Add student", payload);
    }
}
