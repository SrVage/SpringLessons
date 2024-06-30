package com.example.Lesson_2.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty("app.auto-create-students.enabled")
public class FillStudentService {
    private final StudentServiceImpl studentService;
    private final static String[] firstName = {"John", "Mike", "Sarah", "Emily", "Chris", "Jessica", "David", "Ashley", "James", "Laura"};
    private final static String[] lastName = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Wilson"};
    private final static int minAge = 20;
    private final static int maxAge = 60;

    @PostConstruct
    private void init(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            studentService.add(firstName[i], lastName[i], random.nextInt(maxAge - minAge + 1) + minAge);
        }
    }
}
