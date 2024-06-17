package org.example.exceptions;

public class BadFormatException extends RuntimeException{
    public BadFormatException(String message){
        super(message);
    }
}
