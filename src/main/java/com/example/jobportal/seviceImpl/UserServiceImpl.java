package com.example.jobportal.seviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportal.dto.UserDto;
import com.example.jobportal.dto.response.CompanyResponseDto;
import com.example.jobportal.model.Company;
import com.example.jobportal.model.User;
import com.example.jobportal.repository.UserRepository;
import com.example.jobportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDto createUser(UserDto dto) {
	    // Convert DTO to Entity
	    User user = modelMapper.map(dto, User.class);

	    // Save entity
	    User savedUser = userRepo.save(user);

	    // Convert Entity back to DTO
	    return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(int userId) {
	    User user = userRepo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("Company not found with ID: " + userId));

	    return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		  return userRepo.findAll()
		            .stream()
		            .map(user -> modelMapper.map(user, UserDto.class))
		            .toList();
	}

	@Override
	public UserDto updateUser(int userId, UserDto dto) {
		// TODO Auto-generated method stub
		   User user = userRepo.findById(userId)
		            .orElseThrow(() -> new RuntimeException("Company not found with ID: " + userId));

		    // Copy DTO values to existing entity
		    modelMapper.map(dto, user);

		    User updatedUser = userRepo.save(user);

		    return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		 userRepo.deleteById(userId);
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username).orElse(null);
	}
	
}
