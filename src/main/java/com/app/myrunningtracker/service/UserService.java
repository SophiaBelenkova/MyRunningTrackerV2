package com.app.myrunningtracker.service;

import com.app.myrunningtracker.entity.UserEntity;
import com.app.myrunningtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity register(UserEntity user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return ResponseEntity.badRequest().body("The username is taken");
        }
        return userRepository.save(user);
    }
}
