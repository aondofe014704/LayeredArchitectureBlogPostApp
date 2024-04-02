package com.Application.BlogApp.data.repository;

import com.Application.BlogApp.data.model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, String> {

}
