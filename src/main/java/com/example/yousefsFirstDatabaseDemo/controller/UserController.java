package com.example.yousefsFirstDatabaseDemo.controller;

import com.example.yousefsFirstDatabaseDemo.bo.CreateUserRequest;
import com.example.yousefsFirstDatabaseDemo.bo.UserResponse;
import com.example.yousefsFirstDatabaseDemo.entity.UserEntity;
import com.example.yousefsFirstDatabaseDemo.enums.Status;
import com.example.yousefsFirstDatabaseDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping
    public List<UserEntity> getAllUsers() {

        return userService.getAllUsers();
    }


    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);

        // Check if the response is not null (indicating a successful creation)
        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            // Handle the case where the creation was not successful (e.g., validation failed)
            // You can return a different status code or error message as needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    // Update user status
    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(
            @RequestParam Long id,
            @RequestParam String status) {
        try {
            userService.updateUserStatus(id, status);
            return ResponseEntity.ok("UserId:" + id + " Status has been Updated to " + status);
        } catch (IllegalArgumentException e) {
            // Log the error message for debugging
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}