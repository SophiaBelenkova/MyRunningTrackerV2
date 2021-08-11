package com.app.myrunningtracker.controller;


import com.app.myrunningtracker.entity.UserEntity;
import com.app.myrunningtracker.exceptions.UserAlreadyExistsException;
import com.app.myrunningtracker.exceptions.UserNotFoundException;
import com.app.myrunningtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user){
        try{
            userService.register(user);
            return ResponseEntity.ok("Registered");
        } catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        try{
            userService.login(user);
            return ResponseEntity.ok().body("Authorized");
        }
        catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            userService.delete(id);

            return ResponseEntity.ok().body("User deleted");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

}
