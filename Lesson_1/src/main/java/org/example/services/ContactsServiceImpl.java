package org.example.services;

import org.example.entities.Contact;
import org.example.exceptions.BadFormatException;
import org.example.tools.CheckFormat;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class ContactsServiceImpl implements ContactsService{
    Set<Contact> contacts = new HashSet<>();

    @Override
    public void add(String fullName, String phoneNumber, String email) throws BadFormatException{
        fullName = CheckFormat.checkFullName(fullName);
        phoneNumber = CheckFormat.checkPhoneNumber(phoneNumber);
        email = CheckFormat.checkEmail(email);
        Contact contact = new Contact(fullName, phoneNumber, email);
        var result  = contacts.add(contact);
        if (!result){
            throw new IllegalArgumentException("Уже есть такой пользователь");
        }
    }

    @Override
    public String showAllContacts(){
        StringBuilder builder = new StringBuilder();
        contacts.forEach(contact -> builder.append(contact).append("\n"));
        return builder.toString();
    }

    @Override
    public void deleteContactByEmail(String email) throws BadFormatException{
        email = CheckFormat.checkEmail(email);
        String finalEmail = email;
        var optionalContact = contacts.stream().filter(contact->contact.getEmail().equals(finalEmail)).findFirst();
        if (optionalContact.isPresent()){
            contacts.remove(optionalContact.get());
        } else{
            throw new NoSuchElementException("Нет такого контакта");
        }
    }
}
