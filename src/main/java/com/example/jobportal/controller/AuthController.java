package com.example.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.dto.request.LoginRequest;
import com.example.jobportal.dto.response.LoginResponse;
import com.example.jobportal.model.User;
import com.example.jobportal.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	   
	  @Autowired
	  private UserService userService;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

	        User user = userService.findByUsername(request.getUsername());

	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                    .body("Invalid username");
	        }

	        if (!user.getPassword().equals(request.getPassword())) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                    .body("Invalid password");
	        }

	        LoginResponse response = LoginResponse.builder()
	                .userId(user.getUserId())
	                .username(user.getUsername())
	               // .role(user.getRole())
	                .message("Login Successful")
	                .build(); 

	        return ResponseEntity.ok(response);
	    }

}
