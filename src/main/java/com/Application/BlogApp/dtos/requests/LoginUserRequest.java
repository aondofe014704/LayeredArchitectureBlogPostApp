package com.Application.BlogApp.dtos.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
