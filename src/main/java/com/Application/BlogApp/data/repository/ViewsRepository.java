package com.Application.BlogApp.data.repository;

import com.Application.BlogApp.data.model.Views;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewsRepository extends MongoRepository<Views, String> {
}
