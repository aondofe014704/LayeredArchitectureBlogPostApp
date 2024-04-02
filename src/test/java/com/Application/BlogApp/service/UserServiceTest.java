package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Posts;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.model.Views;
import com.Application.BlogApp.data.repository.CommentsRepository;
import com.Application.BlogApp.data.repository.PostsRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.data.repository.ViewsRepository;
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
    PostsRepository postsRepository;
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    ViewsRepository viewsRepository;
    @Test
    public void testToRegisterUser(){
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("username");
        registerUserRequest.setPassword("password");
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
        registerUserRequest.setPassword("password");
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
        userService.register(registerUserRequest);
        loginUserRequest.setUsername("username1");
        loginUserRequest.setPassword("password");
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
        CreatePostsRequest createPostsRequest = new CreatePostsRequest();
        createPostsRequest.setTitle("Title");
        createPostsRequest.setAuthor("Author");
        createPostsRequest.setContent("content");
        userService.createPosts(createPostsRequest);
        assertEquals(1, postsRepository.count());
    }
    @Test
    public void testCreateComment(){
        commentsRepository.deleteAll();
        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        User user = new User();
        createCommentRequest.setComment("Comment");
        createCommentRequest.setTitleOfThePost("TitleOfThePost");
        createCommentRequest.setCommenter(user);
        userService.createComment(createCommentRequest);
        assertEquals(1, commentsRepository.count());
    }
    @Test
    public void testToViewPosts(){
        CreateViewsRequest createViewsRequest = new CreateViewsRequest();
        viewsRepository.deleteAll();
        Views views = new Views();
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
        Posts posts = new Posts();
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