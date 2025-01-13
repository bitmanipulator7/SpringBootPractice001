package com.example.SpringBootPractice001.controllers;

import com.example.SpringBootPractice001.models.User;
import com.example.SpringBootPractice001.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create or Update User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createorUpdateUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            // return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
            // Return the user as a ResponseEntity
            return ResponseEntity.ok(user.get());
        } else {
            // If the user is not found, return a custom message with 404 status
            String errorMessage = "No user found for the id " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    // Get all Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Delete User by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        int affectedRows = userService.deleteUserById(id);

        if (affectedRows == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with id " + id + " could not be deleted. Check if it exists.");
        }
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("User with id " + id + " was successfully deleted.");
    }
}
