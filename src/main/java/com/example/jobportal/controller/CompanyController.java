package com.example.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.dto.CompanyResponseDto;
import com.example.jobportal.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyDto dto) {

        CompanyResponseDto response = companyService.createCompany(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	
}
