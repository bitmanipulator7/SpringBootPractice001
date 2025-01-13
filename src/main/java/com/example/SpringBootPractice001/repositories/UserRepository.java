package com.example.SpringBootPractice001.repositories;

import com.example.SpringBootPractice001.models.User;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    // We can define custom queries here as per our requirement, such as:
    // User findByEmail(String email);
    @Modifying
    @Query("DELETE FROM User u WHERE u.id = :id")
    int deleteUserById(@Param("id") Long id);
}
