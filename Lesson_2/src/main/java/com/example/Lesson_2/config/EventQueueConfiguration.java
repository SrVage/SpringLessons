package com.example.Lesson_2.config;

import com.example.Lesson_2.events.EventHandler;
import com.example.Lesson_2.events.EventQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventQueueConfiguration {

    @Bean
    public EventHandler eventHandler(EventQueue eventQueue){
        System.out.println("Create");
        return new EventHandler(eventQueue);
    }
}
