package com.pranay.cheddit.cheddit.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
