package org.example.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Contact {
    private final String fullName;
    private final String phoneNumber;
    private final String email;

    @Override
    public String toString() {
        return String.format("%s | %s | %s",fullName, phoneNumber, email);
    }
}
