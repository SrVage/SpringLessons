package com.example.Lesson_2.events;

public class DeleteStudentEvent extends Event{
    public DeleteStudentEvent(Object source, String payload) {
        super(source, "Delete student", payload);
    }
}
