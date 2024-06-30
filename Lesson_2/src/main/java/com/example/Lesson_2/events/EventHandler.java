package com.example.Lesson_2.events;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@RequiredArgsConstructor
@Component
public class EventHandler {
    private static final Logger logger = Logger.getLogger(EventHandler.class.getName());

    @EventListener(AddStudentEvent.class)
    public void onAddStudentEvent(Event event){
        logger.info(event.getReason()+" "+event.getPayload());
    }

    @EventListener(DeleteStudentEvent.class)
    public void onDeleteStudentEvent(Event event){
        logger.warning(event.getReason()+" "+event.getPayload());
    }

    @EventListener(ErrorEvent.class)
    public void onErrorEvent(Event event){
        logger.warning("!!!!!" + event.getReason()+" "+event.getPayload());
    }
}
