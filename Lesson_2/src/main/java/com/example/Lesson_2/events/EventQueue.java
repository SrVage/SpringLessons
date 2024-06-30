package com.example.Lesson_2.events;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventQueue {
    private final BlockingQueue<Event> eventsQueue = new LinkedBlockingQueue<>();

    public void addEvent(Event event){
        try {
            eventsQueue.put(event);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Event getEvent(){
        try {
            return eventsQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
