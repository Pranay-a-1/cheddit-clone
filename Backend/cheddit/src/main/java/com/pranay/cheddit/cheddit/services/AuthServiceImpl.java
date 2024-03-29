package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.LoginRequest;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import com.pranay.cheddit.cheddit.exceptions.PasswordsDoNotMatchException;
import com.pranay.cheddit.cheddit.exceptions.UserAlreadyExistsException;
import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordAuthService passwordAuthService;

    @Async
    @Override
    public CompletableFuture<AuthenticationResponse>  registerUser(RegisterRequest registerRequest) {
        // Check if user exists
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent() ||
                userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Username or Email already exists");
        }

        // Validate password
        if (!registerRequest.getPassword().equals(registerRequest.getConfirmPassword())) {
            throw new PasswordsDoNotMatchException("Passwords do not match");
        }

        // Hash the password
        String hashedPassword = passwordAuthService.hashPassword(registerRequest.getPassword());

        // Create and save user
               User newUser = new User(registerRequest.getUsername(),
                registerRequest.getEmail(), hashedPassword, LocalDateTime.now(), LocalDateTime.now());
        userRepository.save(newUser);

        // Generate JWT token
        String jwt = passwordAuthService.generateJwtToken(newUser);


        return CompletableFuture.completedFuture(AuthenticationResponse.builder()
                .token(jwt)
                .username(newUser.getUsername())
                .build());
    }

    @Async
    @Override
    public CompletableFuture<AuthenticationResponse> loginUser(LoginRequest loginRequest) {
        log.info("Async loginUser method called on thread: " + Thread.currentThread().getName());
        // Check if user exists
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));



        // Validate password
        if (!passwordAuthService.validatePassword(loginRequest.getPassword(), user.getPassword())) {
            throw new PasswordsDoNotMatchException("Passwords incorrect");
        }

        // Generate JWT token
        String jwt = passwordAuthService.generateJwtToken(user);

        // Create and return AuthenticationResponse using builder pattern
        return CompletableFuture.completedFuture(AuthenticationResponse.builder()
                .token(jwt)
                .username(user.getUsername())
                .build());
    }

}
