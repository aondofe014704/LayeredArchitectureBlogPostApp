package com.Application.BlogApp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String response){
        super(response);
    }
}
