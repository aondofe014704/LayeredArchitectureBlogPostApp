package com.Application.BlogApp.data.repository;
import com.Application.BlogApp.data.model.Posts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @BeforeEach
    public void setUp(){
        postsRepository.deleteAll();
    }
    @Test
    public void testToSaveAPostInTheRepository(){
        Posts post = new Posts();
        post.setContent("Content");
        post.setTitle("Title");
        postsRepository.save(post);
        assertEquals(1, postsRepository.count());
    }
    @Test
    public void testToSaveTwiceInToTheRepository(){
        Posts posts = new Posts();
        Posts posts1 = new Posts();
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
        Posts posts = new Posts();
        posts.setContent("Content");
        posts.setTitle("Title");
        postsRepository.save(posts);
        assertEquals(1, postsRepository.count());
    }
}