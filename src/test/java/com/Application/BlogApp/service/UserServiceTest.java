package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Post;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.model.View;
import com.Application.BlogApp.data.repository.CommentRepository;
import com.Application.BlogApp.data.repository.PostRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.data.repository.ViewRepository;
import com.Application.BlogApp.dtos.requests.*;
import com.Application.BlogApp.exceptions.UserDoesNotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postsRepository;
    @Autowired
    CommentRepository commentsRepository;
    @Autowired
    ViewRepository viewsRepository;
    @Test
    public void testToRegisterUser(){
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("john7777");
        registerUserRequest.setPassword("password!34");
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
        userService.register(registerUserRequest);
        assertEquals(1, userService.numberOfUsers());
    }
    @Test
    public void testToLoginUser(){
        postsRepository.deleteAll();
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("username1");
        registerUserRequest.setPassword("password@123");
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
        userService.register(registerUserRequest);
        loginUserRequest.setUsername("username1");
        loginUserRequest.setPassword("password@123");
        userService.login(loginUserRequest);
        User  user = userRepository.findUserByUserName(loginUserRequest.getUsername());
        assertTrue(user.isLogin());
    }
    @Test void logInWithIncorrectPassword_throwIncorrectPasswordException(){
        assertThrows(UserDoesNotExistException.class,
        ()->userService.findUserByUsername("abbey spending"));
    }
    @Test
    public void  testToCreatePosts(){
        postsRepository.deleteAll();
        CreatePostRequest createPostsRequest = new CreatePostRequest();
        createPostsRequest.setUserId("661a4fdb7427b360e0abe6a5");
        createPostsRequest.setTitle("Title");
        createPostsRequest.setContent("content");
        userService.createPost(createPostsRequest);
        assertEquals(1, postsRepository.count());
    }
//    @Test
//    public void testCreateComment(){
//        commentsRepository.deleteAll();
//        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
//        User user = new User();
//        createCommentRequest.setComment("Comment");
//        createCommentRequest.setCommenterId(user);
//        userService.createComment(createCommentRequest);
//        assertEquals(1, commentsRepository.count());
//    }
    @Test
    public void testToViewPosts(){
        CreateViewRequest createViewsRequest = new CreateViewRequest();
        viewsRepository.deleteAll();
        View views = new View();
        User user = new User();
        createViewsRequest.setTitle("Title");
        createViewsRequest.setContent("content");
        createViewsRequest.setCommenter(user);
        userService.viewPosts(createViewsRequest);
        assertEquals(1, viewsRepository.count());
    }
    @Test
    public void testToDeletePost(){
        DeletePostRequest deletePostRequest = new DeletePostRequest();
        Post posts = new Post();
        deletePostRequest.setId("id");
        deletePostRequest.setContent("Content");
        deletePostRequest.setTitle("Title");
        userService.deletePost(deletePostRequest);
        assertEquals(0, postsRepository.count());
    }
    @Test
    public void testToFindByAuthor(){


    }

}