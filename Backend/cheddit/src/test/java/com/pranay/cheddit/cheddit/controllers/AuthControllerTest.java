package com.pranay.cheddit.cheddit.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pranay.cheddit.cheddit.dto.AuthenticationResponse;
import com.pranay.cheddit.cheddit.dto.LoginRequest;
import com.pranay.cheddit.cheddit.dto.RegisterRequest;
import com.pranay.cheddit.cheddit.services.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @Test
    public void testSignupWithInvalidUsername() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("invalidtestUser@");
        registerRequest.setEmail("testUser@gmail.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");

        mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(registerRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(Objects.requireNonNull(result.getResolvedException()).getMessage().contains("Username can only contain letters and numbers")));
    }

    @Test
    public void testSignupWithInvalidEmail() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testUser");
        registerRequest.setEmail("invalidEmail");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");

        mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(registerRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(Objects.requireNonNull(result.getResolvedException()).getMessage().contains("Email is not valid")));
    }


   @Test
   public void testSignup() throws Exception  {
       RegisterRequest registerRequest = new RegisterRequest();
       registerRequest.setUsername("testUser");
       registerRequest.setEmail("testUser@example.com");
       registerRequest.setPassword("password");
       registerRequest.setConfirmPassword("password");

       when(authService.registerUser(registerRequest)).thenReturn(CompletableFuture.completedFuture(new AuthenticationResponse("token", "testUser")));

       mockMvc.perform(post("/user/register")
               .contentType(MediaType.APPLICATION_JSON)
               .content(new ObjectMapper().writeValueAsString(registerRequest)))
               .andExpect(status().isOk());
   }

    @Test
    public void testLogin_fails() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        when(authService.loginUser(loginRequest)).thenReturn(null);

        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testLogin_throws_Error() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        when(authService.loginUser(loginRequest)).thenThrow(new RuntimeException("Error"));


        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testLogin_Success() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("testUser@gmail.com");
        loginRequest.setPassword("password");

        when(authService.loginUser(loginRequest)).thenReturn(CompletableFuture.completedFuture(new AuthenticationResponse("token", "testUser")));

        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(loginRequest)))
                .andExpect(status().isOk());


    }
}