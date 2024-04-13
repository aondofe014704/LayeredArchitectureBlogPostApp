package com.Application.BlogApp.dtos.response;

import com.Application.BlogApp.data.model.Comment;
import com.Application.BlogApp.data.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreatePostResponse {
    private String userId;
    private String title;
    private String content;
    private User author;
    private final LocalDateTime createAt = LocalDateTime.now();
    private String message;
    private String postId;
    private List<Comment> comments = new ArrayList<>();

}
