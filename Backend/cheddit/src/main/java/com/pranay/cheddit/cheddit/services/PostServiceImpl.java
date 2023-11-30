package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.exceptions.UserNotFoundException;
import com.pranay.cheddit.cheddit.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.pranay.cheddit.cheddit.models.Post;
import com.pranay.cheddit.cheddit.repositories.UserRepository;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PasswordAuthService passwordAuthService;
    private final UserRepository userRepository;

    @Async
    @Override
    public void createNewPost(NewPostRequest newPostRequest) {
        // remove the Word Bearer from the token
        String token = newPostRequest.getAccessToken().split(" ")[1];

        Post post = new Post();

        String username = passwordAuthService.getUserFromToken(token);

        //find user by username
        post.setUser(userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found")));

        post.setPostText(newPostRequest.getPostText());

        postRepository.save(post);

    }
}
