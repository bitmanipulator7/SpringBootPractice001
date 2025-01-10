package com.example.SpringBootPractice001.repositories;

import com.example.SpringBootPractice001.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // We can define custom queries here as per our requirement, such as:
    // User findByEmail(String email);
}
