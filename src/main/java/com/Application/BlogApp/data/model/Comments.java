package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Comments")
public class Comments {
    private String id;
    private String comment;
    private String titleOfThePost;
    private User commenter;

}
