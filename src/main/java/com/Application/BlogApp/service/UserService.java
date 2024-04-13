package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.dtos.requests.*;
import com.Application.BlogApp.dtos.response.CreateCommentResponse;
import com.Application.BlogApp.dtos.response.CreatePostResponse;


public interface UserService {
    User register(RegisterUserRequest registerUserRequest);


    long numberOfUsers();

    boolean login(LoginUserRequest loginUserRequest);

    CreatePostResponse createPost(CreatePostRequest createPostsRequest);
    void viewPosts(CreateViewRequest createViewsRequest);

    void deletePost(DeletePostRequest deletePostRequest);

    void findUserByUsername(String abbeySpending);

}
