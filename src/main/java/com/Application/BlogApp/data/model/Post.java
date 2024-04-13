package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("Posts")
public class Post {
    private String id;
    private String title;
    private String content;
    @DBRef
    private List<Comment> listOfCommnents = new ArrayList<>();
    @DBRef
    private List<View> listOfViews = new ArrayList<>();
    private LocalDateTime createAt = LocalDateTime.now();

}
