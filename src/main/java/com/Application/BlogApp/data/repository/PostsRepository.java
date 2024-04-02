package com.Application.BlogApp.data.repository;

import com.Application.BlogApp.data.model.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Posts, String > {


}
