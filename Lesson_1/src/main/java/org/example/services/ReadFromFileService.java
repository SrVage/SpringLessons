package org.example.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class ReadFromFileService implements ReadService{
    private final ContactsService contactsService;
    private final String filePath;

    public ReadFromFileService(ContactsService contactsService,
                               @Value("${app.default-contact-path}") String filePath,
                               @Value("${spring.profiles.active}") String activeProfile){
        this.contactsService = contactsService;
        this.filePath = filePath;
        if (!activeProfile.equals("init")){
            return;
        }
        try {
            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException {
        try (InputStream inputStream = ReadFromFileService.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Файл с контактами не найден: " + filePath);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parameters = line.split(";");
                    if (parameters.length > 2) {
                        contactsService.add(parameters[0], parameters[1], parameters[2]);
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
    }
}
