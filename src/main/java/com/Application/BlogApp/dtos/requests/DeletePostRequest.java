package com.Application.BlogApp.dtos.requests;

import lombok.Data;

@Data
public class DeletePostRequest {
    private String title;
    private String content;
    private String id;
}
