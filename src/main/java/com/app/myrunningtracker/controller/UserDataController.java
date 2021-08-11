package com.app.myrunningtracker.controller;

import com.app.myrunningtracker.entity.UserDataEntity;
import com.app.myrunningtracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class UserDataController {

    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addRecord(@RequestBody UserDataEntity data) {
        try {
            userDataService.addNewRecord(data);
            return ResponseEntity.ok("Added a new record");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred");
        }
    }

    @GetMapping("/{user_id}")
    public List<UserDataEntity> getAllRecords(@PathVariable int user_id) {
        try {
            return userDataService.getRecords(user_id);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Nothing has been found");
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable int id) {
        try {
            userDataService.deleteRecordById(id);
            return ResponseEntity.ok("Record deleted");
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Nothing has been found");
        }
        return null;
    }

    @PutMapping("/{user_id}/{id}")
    public ResponseEntity<?> updateRecord(@RequestBody UserDataEntity data, @PathVariable int user_id, @PathVariable int id) {
        try {
            userDataService.updateRecord(data, user_id, id);
            return ResponseEntity.ok("Record updated");
        } catch (Exception e) {
           return ResponseEntity.badRequest().body("An error occurred");
        }
    }

}
