package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("Posts")
public class Posts {
    private String id;
    private String title;
    private String content;
    private User author;
    private List<Comments> listOfCommnents = new ArrayList<>();
    private List<Views> listOfViews = new ArrayList<>();
    private LocalDateTime createAt = LocalDateTime.now();

}
