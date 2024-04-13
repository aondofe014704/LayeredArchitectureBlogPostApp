package com.Application.BlogApp.data.repository;

import com.Application.BlogApp.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String > {


}
