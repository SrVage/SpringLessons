package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.Messages;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class InputServiceImpl implements InputService{
    private static final Logger logger = Logger.getLogger(InputServiceImpl.class.getName());
    private final ContactsService contactsService;


    @Override
    public void startInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                logger.info(Messages.HELLO_MESSAGE.toString());
                int input = Integer.parseInt(reader.readLine());
                switch (input){
                    case 0:
                        return;
                    case 1:
                        showAllContacts();
                        break;
                    case 2:
                        addNewContact(reader);
                        break;
                    case 3:
                        deleteContact(reader);
                        break;
                    case 4:
                        saveInFile();
                        break;
                    default:
                        logger.warning(Messages.BAD_OPERATION.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveInFile() {
        try {
            contactsService.saveContacts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContact(BufferedReader reader) {
        try {
            logger.info(Messages.INPUT_EMAIL_FOR_DELETE.toString());
            String email = reader.readLine();
            contactsService.deleteContactByEmail(email);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void addNewContact(BufferedReader reader) {
        try {
            logger.info(Messages.INPUT_CONTACT_NAME.toString());
            String fullName = reader.readLine();

            logger.info(Messages.INPUT_PHONE_NUMBER.toString());
            String phoneNumber = reader.readLine();

            logger.info(Messages.INPUT_EMAIL.toString());
            String email = reader.readLine();

            contactsService.add(fullName, phoneNumber, email);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void showAllContacts() {
        logger.info(contactsService.showAllContacts());
    }
}
