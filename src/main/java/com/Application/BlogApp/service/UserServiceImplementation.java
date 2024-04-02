package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Comments;
import com.Application.BlogApp.data.model.Posts;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.model.Views;
import com.Application.BlogApp.data.repository.CommentsRepository;
import com.Application.BlogApp.data.repository.PostsRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.data.repository.ViewsRepository;
import com.Application.BlogApp.dtos.requests.*;
import com.Application.BlogApp.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
   @Autowired
    UserRepository userRepository;
   @Autowired
   PostsRepository postsRepository;
   @Autowired
    CommentsRepository commentsRepository;
   @Autowired
    ViewsRepository viewsRepository;

    @Override
    public User register(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUserName(registerUserRequest.getUserName());
        user.setPassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        userRepository.save(user);
        return user;
    }

    @Override
    public long numberOfUsers() {
        return userRepository.count();
    }

    @Override
    public void login(LoginUserRequest loginUserRequest) {
        User user = userRepository.findUserByUserName(loginUserRequest.getUsername());
        if(user != null && loginUserRequest.getPassword().equalsIgnoreCase(user.getPassword()))user.setLogin(true);
        userRepository.save(user);
    }

    @Override
    public void createPosts(CreatePostsRequest createPostsRequest) {
        Posts posts = new Posts();
        posts.setTitle(createPostsRequest.getTitle());
        posts.setTitle(createPostsRequest.getTitle());
        posts.setContent(createPostsRequest.getContent());
        postsRepository.save(posts);
    }

    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        User user = new User();
        Comments comments = new Comments();
        comments.setTitleOfThePost(createCommentRequest.getTitleOfThePost());
        comments.setComment(createCommentRequest.getComment());
        comments.setCommenter(createCommentRequest.getCommenter());
        commentsRepository.save(comments);
    }

    @Override
    public void viewPosts(CreateViewsRequest createViewsRequest) {
        Views views = new Views();
        CreateViewsRequest createViewsRequest1 = new CreateViewsRequest();
        createViewsRequest1.setCommenter(createViewsRequest1.getCommenter());
        createViewsRequest1.setContent(createViewsRequest1.getContent());
        createViewsRequest1.setTitle(createViewsRequest1.getTitle());
        viewsRepository.save(views);
    }

    @Override
    public void deletePost(DeletePostRequest deletePostRequest) {
        postsRepository.deleteAll();
        Posts posts = new Posts();
        DeletePostRequest deletePostRequest1 = new DeletePostRequest();
        deletePostRequest1.setId(deletePostRequest.getId());
        deletePostRequest1.setTitle(deletePostRequest1.getTitle());
        deletePostRequest1.setContent(deletePostRequest1.getContent());
        if(posts != null && deletePostRequest.getTitle().equals(posts.getId()))postsRepository.delete(posts);



    }

    @Override
    public void findUserByUsername(String userName) {
        if(userRepository.findUserByUserName(userName) == null) throw new UserDoesNotExistException
                (String.format("%s does not exist", userName));
    }

}
