package com.app.myrunningtracker.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public ResponseEntity register(){
        try{
            return ResponseEntity.ok("Registered");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }
}
