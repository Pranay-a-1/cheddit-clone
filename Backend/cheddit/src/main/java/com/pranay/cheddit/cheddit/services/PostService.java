package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.NewPostRequest;
import com.pranay.cheddit.cheddit.models.Post;

import java.util.List;

public interface PostService {
    void createNewPost(NewPostRequest newPostRequest);

    List<Post> getAllPosts();
}
