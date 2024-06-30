package com.example.Lesson_2.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
public class Event extends ApplicationEvent {
    private final UUID id;
    private final String payload;
    private final String reason;

    protected Event(Object source, String reason, String payload){
        super(source);
        id = UUID.randomUUID();
        this.payload = payload;
        this.reason = reason;
    }
}
