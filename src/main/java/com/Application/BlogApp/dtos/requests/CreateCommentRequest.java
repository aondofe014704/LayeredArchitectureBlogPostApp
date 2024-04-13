package com.Application.BlogApp.dtos.requests;

import com.Application.BlogApp.data.model.User;
import lombok.Data;

@Data
public class CreateCommentRequest {
    private String postId;
    private String comment;
    private String commenterId;

}
