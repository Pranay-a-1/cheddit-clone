package com.pranay.cheddit.cheddit.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
import com.pranay.cheddit.cheddit.models.Post;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.services.PasswordAuthService;
import com.pranay.cheddit.cheddit.services.PostService;
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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.pranay.cheddit.cheddit.repositories.UserRepository;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordAuthService passwordAuthService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PostService postService;

    @Test
    public void testCreateNewPost() throws Exception {
        NewPostRequest newPostRequest = new NewPostRequest();
        newPostRequest.setPostText("This is a new post");
        newPostRequest.setAccessToken("Bearer token");

        // Mock the getUserFromToken method
        when(passwordAuthService.getUserFromToken(Mockito.anyString())).thenReturn("username");

        // Create a User object with a username
        User user = new User();
        user.setUsername("username");

        // Mock the findByUsername method
        when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));

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

//    @Test
//    public void testCreateNewPost_fails_with_userNotFound_Exception() throws Exception {
//        NewPostRequest newPostRequest = new NewPostRequest();
//        newPostRequest.setPostText("This is a new post");
//        newPostRequest.setAccessToken("Bearer token");
//
//        // Mock the getUserFromToken method
//        when(passwordAuthService.getUserFromToken(Mockito.anyString())).thenReturn("username");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String newPostRequestJson = objectMapper.writeValueAsString(newPostRequest);
//
//
//        mockMvc.perform(post("/new-post")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(newPostRequestJson))
//                .andExpect(status().isBadRequest())
//                .andExpect(result -> assertTrue(Objects.requireNonNull(result.getResolvedException()).getMessage().contains("User not found")));
//    }

    @Test
    public void testGetAllPosts() throws Exception {
        // Mock the service method
        when(postService.getAllPosts()).thenReturn(Arrays.asList(new Post(), new Post()));

        // Perform the GET request
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        // Convert the response to a list of posts
        String content = mvcResult.getResponse().getContentAsString();
        List<Post> posts = new ObjectMapper().readValue(content, new TypeReference<List<Post>>() {});

        // Assert that the list has the expected size
        assertEquals(2, posts.size());
    }

    @Test
    public void testGetAllPosts_fails() throws Exception {
        // Mock the service method
        when(postService.getAllPosts()).thenThrow(new RuntimeException("Error"));

        // Perform the GET request
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isBadRequest())
                .andReturn();

        // Assert that the list has the expected size
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Error"));
    }

}




