package com.example.Lesson_2.events;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class EventHandler {
    private final EventQueue eventQueue;
    private static final Logger logger = Logger.getLogger(EventHandler.class.getName());

    @EventListener(ApplicationReadyEvent.class)
    public void startEventHandler(){
        logger.info("Start");
        Thread eventHandlerThread = new Thread(()->{
            while (true){
                System.out.println("true");
                var event = eventQueue.getEvent();
                if (event != null) {
                    logger.info(event.getPayload());
                } else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });
        eventHandlerThread.start();
    }
}
