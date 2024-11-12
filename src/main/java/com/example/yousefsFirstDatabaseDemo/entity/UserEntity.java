package com.example.yousefsFirstDatabaseDemo.entity;

import com.example.yousefsFirstDatabaseDemo.enums.Status;
import jakarta.persistence.*;

//Entity is like a blueprint that makes sure that every user record has the same structure
// it tells the system what kind of info to store about each user

@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id //Marks this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // specifies how the PK values are generated (typically as an auto-incrementing identity column in the database).
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
