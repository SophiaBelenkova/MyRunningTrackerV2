package com.app.myrunningtracker.controller;


import com.app.myrunningtracker.entity.UserEntity;
import com.app.myrunningtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserEntity user){
        try{

            userRepository.save(user);
            return ResponseEntity.ok("Registered");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        try{
            return ResponseEntity.ok("Authorized");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }
}
