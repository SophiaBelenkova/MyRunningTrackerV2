package com.app.myrunningtracker.service;

import com.app.myrunningtracker.entity.UserEntity;
import com.app.myrunningtracker.exceptions.UserAlreadyExistsException;
import com.app.myrunningtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity register(UserEntity user) throws UserAlreadyExistsException {
        if(userRepository.findByUsername(user.getUsername()) != null){
           throw new UserAlreadyExistsException("This username is already taken");
        }
        return userRepository.save(user);
    }

    public UserEntity login(UserEntity user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
