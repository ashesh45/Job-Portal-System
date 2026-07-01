package com.example.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal.model.User;


public interface UserRepository extends  JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
