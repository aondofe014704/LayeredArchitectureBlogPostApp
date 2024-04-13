package com.Application.BlogApp.exceptions;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String response){
        super(response);
    }
}
