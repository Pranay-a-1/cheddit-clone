package com.pranay.cheddit.cheddit.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.services.PasswordAuthService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.pranay.cheddit.cheddit.repositories.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordAuthService passwordAuthService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testCreateNewPost() throws Exception {
        NewPostRequest newPostRequest = new NewPostRequest();
        newPostRequest.setPostText("This is a new post");
        newPostRequest.setAccessToken("Bearer token");

        // Mock the getUserFromToken method
        Mockito.when(passwordAuthService.getUserFromToken(Mockito.anyString())).thenReturn("username");

        // Create a User object with a username
        User user = new User();
        user.setUsername("username");

        // Mock the findByUsername method
        Mockito.when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));

        ObjectMapper objectMapper = new ObjectMapper();
        String newPostRequestJson = objectMapper.writeValueAsString(newPostRequest);

        mockMvc.perform(post("/new-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newPostRequestJson))
                .andExpect(status().isCreated())
                .andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("New Post created")));
    }

    @Test
    public void testCreateNewPost_fails_with_empty_body() throws Exception {
        //post perform sends a string on sucess
        mockMvc.perform(post("/new-post"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(Objects.requireNonNull(result.getResolvedException()).getMessage().contains("Required request body is missing")));
    }

    @Test
    public void testCreateNewPost_fails_with_userNotFound_Exception() throws Exception {
        NewPostRequest newPostRequest = new NewPostRequest();
        newPostRequest.setPostText("This is a new post");
        newPostRequest.setAccessToken("Bearer token");

        // Mock the getUserFromToken method
        Mockito.when(passwordAuthService.getUserFromToken(Mockito.anyString())).thenReturn("username");

        ObjectMapper objectMapper = new ObjectMapper();
        String newPostRequestJson = objectMapper.writeValueAsString(newPostRequest);


        mockMvc.perform(post("/new-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newPostRequestJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(Objects.requireNonNull(result.getResolvedException()).getMessage().contains("User not found")));
    }

}




