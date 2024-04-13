package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Comment;
import com.Application.BlogApp.data.model.Post;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.model.View;
import com.Application.BlogApp.data.repository.CommentRepository;
import com.Application.BlogApp.data.repository.PostRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.data.repository.ViewRepository;
import com.Application.BlogApp.dtos.requests.*;
import com.Application.BlogApp.dtos.response.CreateCommentResponse;
import com.Application.BlogApp.dtos.response.CreatePostResponse;
import com.Application.BlogApp.exceptions.InvalidArgumentException;
import com.Application.BlogApp.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{
   @Autowired
    UserRepository userRepository;
   @Autowired
   PostRepository postsRepository;
   @Autowired
   CommentRepository commentsRepository;
   @Autowired
   ViewRepository viewsRepository;

    @Override
    public User register(RegisterUserRequest registerUserRequest) {
        User user = new User();
        String userNameRegex = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{3,16}$";
        if (!registerUserRequest.getUserName().matches(userNameRegex)) throw  new InvalidArgumentException("Username must " +
                "Contain lowercase and Numbers");
        user.setUserName(registerUserRequest.getUserName());
        String passwordRegex = "^(?=.*[0-9])(?=.*[!@#$%^&*()])(?=.*[a-z])[a-z0-9!@#$%^&*()]{8,}$";
        if (!registerUserRequest.getPassword().matches(passwordRegex)) throw new InvalidArgumentException("password must contain alphabets, numbers" +
                " and characters");
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
    public boolean login(LoginUserRequest loginUserRequest) {
        User user = userRepository.findUserByUserName(loginUserRequest.getUsername());
//        if(user != null && loginUserRequest.getPassword().equalsIgnoreCase(user.getPassword()))user.setLogin(true);
       if(user!=null && user.getPassword().equals(loginUserRequest.getPassword())){
            user.setLogin(true);
           userRepository.save(user);
       }
        return true;
    }

    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostsRequest) {
        Post post = new Post();
        post.setTitle(createPostsRequest.getTitle());
        post.setContent(createPostsRequest.getContent());
         Post savedPost = postsRepository.save(post);
         Optional<User> foundUser = userRepository.findById(createPostsRequest.getUserId());
         if (foundUser.isPresent()){
             foundUser.get().getListOfPost().add(savedPost);
              userRepository.save(foundUser.get());
         }
         CreatePostResponse createPostResponse = new CreatePostResponse();
         createPostResponse.setMessage("Post Successfully Created.");
         createPostResponse.setPostId(savedPost.getId());
         createPostResponse.setComments(savedPost.getListOfCommnents());
         return createPostResponse;

    }

    @Override
    public void viewPosts(CreateViewRequest createViewsRequest) {
        View views = new View();
        CreateViewRequest createViewsRequest1 = new CreateViewRequest();
        createViewsRequest1.setCommenter(createViewsRequest1.getCommenter());
        createViewsRequest1.setContent(createViewsRequest1.getContent());
        createViewsRequest1.setTitle(createViewsRequest1.getTitle());
        viewsRepository.save(views);
    }

    @Override
    public void deletePost(DeletePostRequest deletePostRequest) {
        postsRepository.deleteAll();
        Post posts = new Post();
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
