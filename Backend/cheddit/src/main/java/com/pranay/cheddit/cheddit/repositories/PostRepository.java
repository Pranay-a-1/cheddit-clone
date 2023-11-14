package com.pranay.cheddit.cheddit.repositories;

import com.pranay.cheddit.cheddit.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
