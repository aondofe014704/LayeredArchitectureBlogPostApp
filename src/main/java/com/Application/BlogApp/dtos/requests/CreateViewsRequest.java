package com.Application.BlogApp.dtos.requests;

import com.Application.BlogApp.data.model.User;
import lombok.Data;

@Data
public class CreateViewsRequest {
    private String title;
    private String content;
    private User commenter;

}
