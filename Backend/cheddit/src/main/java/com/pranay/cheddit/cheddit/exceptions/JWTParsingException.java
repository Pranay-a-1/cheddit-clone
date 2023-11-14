package com.pranay.cheddit.cheddit.exceptions;

public class JWTParsingException extends RuntimeException{
    public JWTParsingException(String message) {
        super(message);
    }
}
