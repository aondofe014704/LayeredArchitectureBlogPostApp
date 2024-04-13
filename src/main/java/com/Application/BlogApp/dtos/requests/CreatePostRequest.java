package com.Application.BlogApp.dtos.requests;

import com.Application.BlogApp.data.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostRequest {
    private String userId;
    private String title;
    private String content;
    private User author;

}
