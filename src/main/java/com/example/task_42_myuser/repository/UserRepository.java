package com.example.task_42_myuser.repository;

import com.example.task_42_myuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}