package com.example.yousefsFirstDatabaseDemo.service;

import com.example.yousefsFirstDatabaseDemo.bo.UserResponse;
import com.example.yousefsFirstDatabaseDemo.entity.UserEntity;
import com.example.yousefsFirstDatabaseDemo.bo.CreateUserRequest;
import com.example.yousefsFirstDatabaseDemo.enums.Status;


import java.util.List;


// This kinda lists all operations we can do related to users
//Kinda like saying we offer this without explaining how its done
// All classes that implements this has to use all methods
public interface UserService {


    List<UserEntity> getAllUsers();
    
    UserResponse createUser(CreateUserRequest request);

    void updateUserStatus(Long id, String status);

}
