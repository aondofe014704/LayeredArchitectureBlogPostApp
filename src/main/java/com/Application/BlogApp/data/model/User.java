package com.Application.BlogApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("User")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private boolean isLogin;
    private List<Posts> listOfPost = new ArrayList<>();

}
