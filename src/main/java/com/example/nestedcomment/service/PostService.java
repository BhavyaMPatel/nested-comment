package com.example.nestedcomment.service;

import com.example.nestedcomment.entity.Post;
import com.example.nestedcomment.entity.User;
import com.example.nestedcomment.repository.PostRepository;
import com.example.nestedcomment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> findPosts(){
        return postRepository.findAll();
    }

    public List<Post> findPostsByUserId(int id){
        List<Post> a = postRepository.findPostsByCreatedBy_Id(id);
        System.out.println("s"+a.size());
        return a;
    }

    public String addPost(int createdBy) throws Exception {
        Post newPost = new Post();
        Optional<User> user = userRepository.findById(createdBy);
        if(user.isPresent()){
            newPost.setCreatedBy(user.get());
            newPost.setCreatedAt(new Date().toInstant());
        }else{
            throw new Exception("User not found");
        }
        postRepository.save(newPost);
        return "Post added";
    }

}
