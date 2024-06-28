package com.example.Lesson_2.entities;

import lombok.*;

@Getter
@RequiredArgsConstructor
@Setter
@ToString
public class Student {
    private int id;
    private final String firstName;
    private final String lastName;
    private final int age;
}
