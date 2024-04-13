package com.Application.BlogApp.data.repository;
import com.Application.BlogApp.data.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class PostsRepositoryTest {
    @Autowired
    PostRepository postsRepository;

    @BeforeEach
    public void setUp(){
        postsRepository.deleteAll();
    }
    @Test
    public void testToSaveAPostInTheRepository(){
        Post post = new Post();
        post.setContent("Content");
        post.setTitle("Title");
        postsRepository.save(post);
        assertEquals(1, postsRepository.count());
    }
    @Test
    public void testToSaveTwiceInToTheRepository(){
        Post posts = new Post();
        Post posts1 = new Post();
        posts.setContent("Content");
        posts.setTitle("Title");
        posts.setContent("ContentOne");
        posts.setTitle("TitleOne");
        postsRepository.save(posts);
        postsRepository.save(posts1);
        assertEquals(2, postsRepository.count());
    }
    @Test
    public void testToCreatePostInTheRepository(){
        Post posts = new Post();
        posts.setContent("Content");
        posts.setTitle("Title");
        postsRepository.save(posts);
        assertEquals(1, postsRepository.count());
    }
}