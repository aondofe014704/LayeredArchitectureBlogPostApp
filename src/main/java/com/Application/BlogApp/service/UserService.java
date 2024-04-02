package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.dtos.requests.*;


public interface UserService {
    User register(RegisterUserRequest registerUserRequest);


    long numberOfUsers();

    void login(LoginUserRequest loginUserRequest);

    void createPosts(CreatePostsRequest createPostsRequest);

    void createComment(CreateCommentRequest createCommentRequest);

    void viewPosts(CreateViewsRequest createViewsRequest);

    void deletePost(DeletePostRequest deletePostRequest);

    void findUserByUsername(String abbeySpending);

}
