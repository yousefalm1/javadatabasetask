package com.example.yousefsFirstDatabaseDemo.service;


import com.example.yousefsFirstDatabaseDemo.bo.CreateUserRequest;
import com.example.yousefsFirstDatabaseDemo.bo.UserResponse;
import com.example.yousefsFirstDatabaseDemo.entity.UserEntity;
import com.example.yousefsFirstDatabaseDemo.enums.Status;
import com.example.yousefsFirstDatabaseDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setStatus(request.getStatus());
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getStatus().toString());
        return response;
    }

    @Override
    public void updateUserStatus(Long id, String status) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));

        if (!Status.isValidStatus(status)) {
            throw new IllegalArgumentException("I think you might have spelt active or inactive wrong");
        }

        user.setStatus(Status.valueOf(status.toUpperCase()));

        userRepository.save(user);
    }
}