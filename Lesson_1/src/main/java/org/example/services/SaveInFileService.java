package org.example.services;

import lombok.NoArgsConstructor;
import org.example.Messages;
import org.example.entities.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import java.util.logging.Logger;

@Component
@NoArgsConstructor
public class SaveInFileService implements SaveService{
    private static final Logger logger = Logger.getLogger(SaveInFileService.class.getName());
    @Value("${app.contact-file-path}")
    private String filePath;

    @Override
    public void save(Set<Contact> contacts) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (var contact : contacts) {
            builder.append(contact.getFullName())
                    .append(";")
                    .append(contact.getPhoneNumber())
                    .append(";")
                    .append(contact.getEmail())
                    .append("\n");
        }
        saveToFile(builder.toString());
    }

    private void saveToFile(String contacts) throws IOException {
        try {
            logger.info(Path.of(filePath).toString());
            Files.writeString(Path.of(filePath), contacts,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IOException(Messages.WRITE_IN_FILE_EXCEPTION.toString());
        }
    }
}
