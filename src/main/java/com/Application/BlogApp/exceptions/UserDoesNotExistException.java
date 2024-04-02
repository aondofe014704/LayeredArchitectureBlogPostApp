package com.Application.BlogApp.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(String response){
        super(response);
    }
}
