package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Comments")
public class Comment {
    private String id;
    private String comment;
    private User commenter;

}
