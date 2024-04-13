package com.Application.BlogApp.service;

import com.Application.BlogApp.dtos.requests.CreateCommentRequest;
import com.Application.BlogApp.dtos.response.CreateCommentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CreateCommentResponse createComment(CreateCommentRequest createCommentRequest);

}
