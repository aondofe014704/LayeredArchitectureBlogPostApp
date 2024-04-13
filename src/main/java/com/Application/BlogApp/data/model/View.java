package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Views")
public class View {
    private String id;
    @DBRef
    private User viewer;
    private LocalDateTime timeOfView = LocalDateTime.now();
}
