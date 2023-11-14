package com.pranay.cheddit.cheddit.controllers;

import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.services.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PostController {

    private final PostService postService;

    @PostMapping("/new-post")
    public ResponseEntity<String> createNewPeep(@Valid @RequestBody NewPostRequest newPostRequest) {
        postService.createNewPost(newPostRequest);
        return new ResponseEntity<>("New Post created" , HttpStatus.CREATED);
    }
}
