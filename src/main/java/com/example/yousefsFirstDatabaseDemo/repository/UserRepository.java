package com.example.yousefsFirstDatabaseDemo.repository;

import com.example.yousefsFirstDatabaseDemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositories help manage data
// it helps organize store and retrieve data
// It's a interface that provides methods to preform operation such as saving a user
// An interface is like a way to define a set of methods a class must implement
// it makes sure that any class that uses the interface will have these methods s

// Interface allows us to do CRUD operations on userEntity objects in the database

@Repository //Indicates this interface is a repository
// UserRepository is an interface
// The interface extends JpaRepository which is a JPA-specific extension of the Spring CrudRepository
// UserEntity the type of entity that the repository manages.
// Long: The type of the entity’s primary key.
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
