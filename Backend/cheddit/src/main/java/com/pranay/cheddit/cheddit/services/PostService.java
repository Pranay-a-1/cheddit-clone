package com.pranay.cheddit.cheddit.services;

import com.pranay.cheddit.cheddit.dto.NewPostRequest;

public interface PostService {
    void createNewPost(NewPostRequest newPostRequest);
}
