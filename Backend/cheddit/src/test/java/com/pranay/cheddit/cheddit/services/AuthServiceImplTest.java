package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import com.pranay.cheddit.cheddit.exceptions.PasswordsDoNotMatchException;
import com.pranay.cheddit.cheddit.exceptions.UserAlreadyExistsException;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordAuthService passwordAuthService;

    @InjectMocks
    private AuthServiceImpl authService;



    @Test
    public void testRegisterUser_UserAlreadyExists() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testUser");
        registerRequest.setEmail("testUser@example.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");

        when(userRepository.findByUsername(registerRequest.getUsername())).thenReturn(Optional.of(new User()));
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.of(new User()));

        assertThrows(UserAlreadyExistsException.class, () -> authService.registerUser(registerRequest));
    }

    @Test
    public void testRegisterUser_PasswordsDoNotMatch() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testUser");
        registerRequest.setEmail("testUser@example.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("differentPassword");

        assertThrows(PasswordsDoNotMatchException.class, () -> authService.registerUser(registerRequest));
    }

    @Test
    public void testRegisterUser_Success() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testUser");
        registerRequest.setEmail("testUser@example.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");

        when(userRepository.findByUsername(registerRequest.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.empty());
        when(passwordAuthService.hashPassword(anyString())).thenReturn("hashedPassword");

        AuthenticationResponse response = authService.registerUser(registerRequest);

        assertNotNull(response);

    }



}