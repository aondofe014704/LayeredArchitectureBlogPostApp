package com.Application.BlogApp.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
}
