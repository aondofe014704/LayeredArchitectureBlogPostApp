package com.Application.BlogApp.dtos.response;

import com.Application.BlogApp.data.model.User;
import lombok.Data;

@Data
public class CreateCommentResponse {
    private String comment;
    private User commenter;
    private String message;
}
