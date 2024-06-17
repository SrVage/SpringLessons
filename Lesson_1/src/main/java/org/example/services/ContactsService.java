package org.example.services;

import org.example.exceptions.BadFormatException;

import java.io.IOException;

public interface ContactsService {
    void add(String fullName, String phoneNumber, String email) throws BadFormatException;

    String showAllContacts();

    void deleteContactByEmail(String email) throws BadFormatException;

    void saveContacts() throws IOException;
}
