package com.Application.BlogApp.dtos.requests;

import com.Application.BlogApp.data.model.User;
import lombok.Data;

@Data
public class CreateCommentRequest {
    private String comment;
    private String titleOfThePost;
    private User commenter;

}
