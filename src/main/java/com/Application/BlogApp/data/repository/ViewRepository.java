package com.Application.BlogApp.data.repository;

import com.Application.BlogApp.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View, String> {
}
