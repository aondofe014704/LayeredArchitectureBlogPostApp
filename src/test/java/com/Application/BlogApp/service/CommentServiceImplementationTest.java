package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Comment;
import com.Application.BlogApp.data.model.Post;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.repository.CommentRepository;
import com.Application.BlogApp.data.repository.PostRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.dtos.requests.CreateCommentRequest;
import com.Application.BlogApp.dtos.requests.CreatePostRequest;
import com.Application.BlogApp.dtos.requests.LoginUserRequest;
import com.Application.BlogApp.dtos.requests.RegisterUserRequest;
import com.Application.BlogApp.dtos.response.CreatePostResponse;
import com.Application.BlogApp.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommentServiceImplementationTest {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Test
    public void testThatAUserCanCommentOnAPost(){
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUserName("john7777");
        registerUserRequest.setPassword("password!34");
        registerUserRequest.setFirstName("firstname");
        registerUserRequest.setLastName("lastname");
       User registeredUser = userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());


        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("username1");
        loginUserRequest.setPassword("password@123");
        boolean isloggedIn = userService.login(loginUserRequest);
        assertTrue(isloggedIn);


        postRepository.deleteAll();
        CreatePostRequest createPostsRequest = new CreatePostRequest();
        createPostsRequest.setUserId(registeredUser.getId());
        createPostsRequest.setTitle("Title");
        createPostsRequest.setContent("content");
         CreatePostResponse createdPost = userService.createPost(createPostsRequest);
        assertEquals(1, postRepository.count());

        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterId(registeredUser.getId());
        createCommentRequest.setPostId(createdPost.getPostId());
        createCommentRequest.setComment("very nice!");
        commentService.createComment(createCommentRequest);
//        assertEquals( 1,commentRepository.count());



    }



}