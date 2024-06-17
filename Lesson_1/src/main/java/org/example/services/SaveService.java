package org.example.services;

import org.example.entities.Contact;

import java.io.IOException;
import java.util.Set;

public interface SaveService {
    void save(Set<Contact> contacts) throws IOException;
}
