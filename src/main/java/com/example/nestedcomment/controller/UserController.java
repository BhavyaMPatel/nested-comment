package com.example.nestedcomment.controller;

import com.example.nestedcomment.entity.User;
import com.example.nestedcomment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/user")
    public User createUser(String username){
        return userService.addUser(username);
    }

}
