package com.example.SpringBootPractice001.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // https://www.baeldung.com/intellij-resolve-spring-boot-configuration-properties
    private long id;
    private String name;
    private String email;

    //constructor
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Getters and Setters
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
