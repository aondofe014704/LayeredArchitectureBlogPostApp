package com.Application.BlogApp.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostsRequest {
    private String id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createAt = LocalDateTime.now();

}
