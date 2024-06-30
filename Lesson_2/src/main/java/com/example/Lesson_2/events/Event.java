package com.example.Lesson_2.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Event {
    private final UUID id;
    private final String payload;

    public Event(String payload){
        id = UUID.randomUUID();
        this.payload = payload;
    }
}
