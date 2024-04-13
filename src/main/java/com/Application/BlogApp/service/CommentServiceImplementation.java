package com.Application.BlogApp.service;

import com.Application.BlogApp.data.model.Comment;
import com.Application.BlogApp.data.model.Post;
import com.Application.BlogApp.data.model.User;
import com.Application.BlogApp.data.repository.CommentRepository;
import com.Application.BlogApp.data.repository.PostRepository;
import com.Application.BlogApp.data.repository.UserRepository;
import com.Application.BlogApp.dtos.requests.CreateCommentRequest;
import com.Application.BlogApp.dtos.response.CreateCommentResponse;
import com.Application.BlogApp.dtos.response.CreatePostResponse;
import com.Application.BlogApp.exceptions.PostNotFoundException;
import com.Application.BlogApp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) {
        Optional<Post> foundPost = postRepository.findById(createCommentRequest.getPostId());
        if (foundPost.isPresent()) {
            Optional<User> foundUser = userRepository.findById(createCommentRequest.getCommenterId());
            if (foundUser.isPresent()) {
                Comment comment = new Comment();
                comment.setComment(createCommentRequest.getComment());
                comment.setCommenter(foundUser.get());
              Comment savedComment = commentRepository.save(comment);
              foundPost.get().getListOfCommnents().add(savedComment);
              postRepository.save(foundPost.get());

            }else {
                throw new UserNotFoundException("User Does Not Exist");
            }
        }else {
            throw new PostNotFoundException("Post Does Not Exist");
        }
        CreateCommentResponse createCommentResponse = new CreateCommentResponse();
        createCommentResponse.setMessage("Comment Created Successfully");
        return createCommentResponse;
    }

}
