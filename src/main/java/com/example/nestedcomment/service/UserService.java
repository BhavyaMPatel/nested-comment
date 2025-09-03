package com.example.nestedcomment.service;

import com.example.nestedcomment.entity.User;
import com.example.nestedcomment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer id){
        return userRepository.findById(id);
    }

    public User addUser(String username){
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }
}
