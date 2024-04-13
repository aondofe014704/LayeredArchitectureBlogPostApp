package com.Application.BlogApp.exceptions;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException(String response){
        super(response);

    }
}
