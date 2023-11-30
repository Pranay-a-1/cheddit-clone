package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.pranay.cheddit.cheddit.repositories.PostRepository;
import com.pranay.cheddit.cheddit.repositories.UserRepository;
import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.models.User;
import com.pranay.cheddit.cheddit.models.Post;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private PasswordAuthService passwordAuthService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void testCreateNewPost() {
        // Arrange
        NewPostRequest newPostRequest = new NewPostRequest();
        newPostRequest.setPostText("This is a new post");
        newPostRequest.setAccessToken("Bearer token");

        User user = new User();
        user.setUsername("username");

        when(passwordAuthService.getUserFromToken("token")).thenReturn("username");
        when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));

        // Act
        postService.createNewPost(newPostRequest);

        // Assert
        verify(postRepository).save(any(Post.class));
    }

    @Test
    void testCreateNewPost_UserNotFound() {
        // Arrange
        NewPostRequest newPostRequest = new NewPostRequest();
        newPostRequest.setPostText("This is a new post");
        newPostRequest.setAccessToken("Bearer token");

        when(passwordAuthService.getUserFromToken("token")).thenReturn("username");
        when(userRepository.findByUsername("username")).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(UserNotFoundException.class, () -> postService.createNewPost(newPostRequest));

        // Assert that save method was never called
        verify(postRepository, Mockito.never()).save(any(Post.class));

    }

    @Test
    void testGetAllPosts_success() {
        // Arrange
        Post post = new Post();
        post.setPostText("This is a post");
        post.setUser(new User());

        when(postRepository.findAll()).thenReturn(List.of(post));

        // Act
        java.util.List<Post> result = postService.getAllPosts();

        // Assert
        assertEquals(List.of(post), result);
    }

    @Test
    void testGetAllPosts_noPosts() {
        // Arrange
        when(postRepository.findAll()).thenReturn(List.of());

        // Act
        java.util.List<Post> result = postService.getAllPosts();

        // Assert
        assertEquals(List.of(), result);
    }
}