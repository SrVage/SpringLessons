package org.example.tools;

import org.example.exceptions.BadFormatException;

public class CheckFormat {
    private static final String firstPhoneRegex = "^7\\d{10}$";
    private static final String secondPhoneRegex = "^8\\d{10}$";
    private static final String thirdPhoneRegex = "^\\d{10}$";
    private static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String fioRegex = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)? [А-ЯЁ][а-яё]+( [А-ЯЁ][а-яё]+)?$";


    private CheckFormat(){

    }

    public static String checkPhoneNumber(String phoneNumber) throws BadFormatException {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");

        if (phoneNumber.matches(firstPhoneRegex)) {
            return phoneNumber;
        } else if (phoneNumber.matches(secondPhoneRegex)) {
            return phoneNumber.replace("8", "7");
        } else if (phoneNumber.matches(thirdPhoneRegex)) {
            return "7" + phoneNumber;
        } else {
            throw new BadFormatException("Неверный формат номера телефона");
        }
    }

    public static String checkEmail(String email) throws BadFormatException {
        if (email.matches(emailRegex)){
            return email;
        } else {
            throw new BadFormatException("Неверный формат email");
        }
    }

    public static String checkFullName(String fullname) throws BadFormatException {
        if (fullname.matches(fioRegex)){
            return fullname;
        } else {
            throw new BadFormatException("Неверный формат ФИО");
        }
    }
}
