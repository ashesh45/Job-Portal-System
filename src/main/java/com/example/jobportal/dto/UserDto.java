package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	

	private String fname;
	private String lname;
	private String email;
	private String username;
	private String phone;
	private String password;

}
