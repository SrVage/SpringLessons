package org.example.services;

import lombok.RequiredArgsConstructor;
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
                logger.info("0 - Выход;\n" +
                        "1 - Показать все контакты;\n" +
                        "2 - Добавить новый контакт;\n" +
                        "3 - Удалить контакт по email;\n" +
                        "4 - Сохранить контакты в файл.");
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
                        logger.warning("Нет такой команды");
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
            logger.info("Введите email удаляемого контакта:");
            String email = reader.readLine();
            contactsService.deleteContactByEmail(email);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void addNewContact(BufferedReader reader) {
        try {
            logger.info("Введите имя контакта:");
            String fullName = reader.readLine();

            logger.info("Введите номер телефона: ");
            String phoneNumber = reader.readLine();

            logger.info("Введите номер email: ");
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
