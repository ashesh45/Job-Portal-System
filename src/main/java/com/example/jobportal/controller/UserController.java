package com.example.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.dto.UserDto;
import com.example.jobportal.dto.request.CompanyRequestDto;
import com.example.jobportal.dto.response.CompanyResponseDto;
import com.example.jobportal.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {

        UserDto response = userService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {

        return ResponseEntity.ok(userService.getUserById(userId));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> user = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
	
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return  ResponseEntity.ok("User deleted successfully");
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Integer userId,
            @Valid @RequestBody UserDto Dto) {

         UserDto response = userService.updateUser(userId, Dto);

        return ResponseEntity.ok(response);
    }

}
