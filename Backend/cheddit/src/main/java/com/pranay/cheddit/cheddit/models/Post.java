package com.pranay.cheddit.cheddit.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "posts")
public class Post {

    private User user;

    private String postText;

    private String taggedUsername;

}