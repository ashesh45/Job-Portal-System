package com.example.jobportal.service;

import java.util.List;

import com.example.jobportal.dto.UserDto;
import com.example.jobportal.model.User;

public interface UserService {
	
    UserDto createUser(UserDto dto);

    UserDto getUserById(int userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(int UserId, UserDto dto);

    void deleteUser(int UserId);

	User findByUsername(String username);

}
