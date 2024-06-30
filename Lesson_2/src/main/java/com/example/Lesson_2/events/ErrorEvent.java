package com.example.Lesson_2.events;

public class ErrorEvent extends Event{
    public ErrorEvent(Object source, String payload) {
        super(source, "Error", payload);
    }
}
