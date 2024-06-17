package org.example.services;

import org.example.exceptions.BadFormatException;

public interface ContactsService {
    void add(String fullName, String phoneNumber, String email) throws BadFormatException;

    String showAllContacts();

    void deleteContactByEmail(String email) throws BadFormatException;
}
