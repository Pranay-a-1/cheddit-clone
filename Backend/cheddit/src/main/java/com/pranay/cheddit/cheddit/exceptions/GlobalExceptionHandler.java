package com.pranay.cheddit.cheddit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (!errorMessage.isEmpty()) {
                errorMessage.append(", ");
            }
            errorMessage.append(error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordsDoNotMatchException.class)
    public ResponseEntity<String> handleUserNotFoundException(PasswordsDoNotMatchException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
