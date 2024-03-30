package com.laioffer.airbnb.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String message) {
        super(message);
    }
}
