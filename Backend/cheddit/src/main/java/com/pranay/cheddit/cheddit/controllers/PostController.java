package com.pranay.cheddit.cheddit.controllers;

import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.models.Post;
import com.pranay.cheddit.cheddit.services.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> allPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/new-post")
    public ResponseEntity<String> createNewPost(@Valid @RequestBody NewPostRequest newPostRequest) {
        postService.createNewPost(newPostRequest);
        return new ResponseEntity<>("New Post created" , HttpStatus.CREATED);
    }
}
