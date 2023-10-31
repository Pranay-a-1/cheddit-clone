package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import com.pranay.cheddit.cheddit.exceptions.PasswordsDoNotMatchException;
import com.pranay.cheddit.cheddit.exceptions.UserAlreadyExistsException;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordAuthService passwordAuthService;

    @Override
    public AuthenticationResponse registerUser(RegisterRequest registerRequest) {
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
        User newUser = new User(null, registerRequest.getUsername(),
                registerRequest.getEmail(), hashedPassword);
        userRepository.save(newUser);

        // Generate JWT token
        String jwt = passwordAuthService.generateJwtToken(newUser);

        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
