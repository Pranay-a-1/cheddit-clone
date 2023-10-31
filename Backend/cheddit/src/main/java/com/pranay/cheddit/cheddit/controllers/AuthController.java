package com.pranay.cheddit.cheddit.controllers;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> signup(@Valid @RequestBody RegisterRequest registerRequest) {
        AuthenticationResponse response = authService.registerUser(registerRequest);
        if (response != null && !response.getToken().isEmpty()) {
            return ResponseEntity.ok("User Registration Successful");
        } else {
            return ResponseEntity.badRequest().body("User Registration Failed");
        }
    }

}