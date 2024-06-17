package org.example;

public enum Messages {
    HELLO_MESSAGE("""
            0 - Выход;
            1 - Создание нового товара;
            2 - Добавить новый контакт;
            3 - Удалить контакт по email;
            4 - Сохранить контакты в файл."""),
    BAD_OPERATION("Неверная операция!"),
    INPUT_EMAIL_FOR_DELETE("Введите email удаляемого контакта:"),
    INPUT_CONTACT_NAME("Введите имя контакта:"),
    INPUT_PHONE_NUMBER("Введите номер телефона:"),
    INPUT_EMAIL("Введите email:"),
    HAS_CONTACT_EXCEPTION("Уже есть такой пользователь"),
    CONTACT_NOT_FOUND_EXCEPTION("Нет такого контакта"),
    WRITE_IN_FILE_EXCEPTION("Ошибка записи в файл");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
