package com.example.nestedcomment.controller;

import com.example.nestedcomment.entity.Post;
import com.example.nestedcomment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.findPosts();
    }

    @GetMapping("/posts/{id}")
    public List<Post> getPostById(Integer id) {
        return postService.findPostsByUserId(id);
    }

    @PostMapping("/posts")
    public String addPost(@RequestBody Integer createdBy) throws Exception {
        return postService.addPost(createdBy);
    }

}
