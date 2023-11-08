package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.LoginRequest;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import com.pranay.cheddit.cheddit.exceptions.PasswordsDoNotMatchException;
import com.pranay.cheddit.cheddit.exceptions.UserAlreadyExistsException;
import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
    public void testRegisterUser_Success() throws ExecutionException, InterruptedException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testUser");
        registerRequest.setEmail("testUser@example.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");

        when(userRepository.findByUsername(registerRequest.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(registerRequest.getEmail())).thenReturn(Optional.empty());
        when(passwordAuthService.hashPassword(anyString())).thenReturn("hashedPassword");

        CompletableFuture<AuthenticationResponse> futureResponse = authService.registerUser(registerRequest);

        AuthenticationResponse response = futureResponse.get();

        assertNotNull(response);

    }


    @Test
    public void testLoginUser_UserNotFound() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> authService.loginUser(loginRequest));

    }

    @Test
    public void testLoginUser_PasswordsDoNotMatch() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        User user = new User();
        user.setEmail("testUser@gmail.com");
        user.setPassword("hashedPassword");
        user.setUsername("testUser");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));
        when(passwordAuthService.validatePassword(loginRequest.getPassword(), user.getPassword())).thenReturn(false);

        assertThrows(PasswordsDoNotMatchException.class, () -> authService.loginUser(loginRequest));
    }

    @Test
    public void testLoginUser_Success() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        User user = new User();
        user.setEmail(loginRequest.getEmail());
        user.setPassword("hashedPassword");
        user.setUsername("testUser");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));
        when(passwordAuthService.validatePassword(loginRequest.getPassword(), user.getPassword())).thenReturn(true);
        when(passwordAuthService.generateJwtToken(user)).thenReturn("jwtToken");

        AuthenticationResponse response = authService.loginUser(loginRequest);

        assertNotNull(response);
        assertEquals(response.getUsername(), user.getUsername());
        assertEquals(response.getToken(), "jwtToken");

    }
}