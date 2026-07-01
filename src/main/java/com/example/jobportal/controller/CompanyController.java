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

import com.example.jobportal.dto.request.CompanyRequestDto;
import com.example.jobportal.dto.response.CompanyResponseDto;
import com.example.jobportal.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<CompanyResponseDto> createCompany(@RequestBody CompanyRequestDto dto) {

        CompanyResponseDto response = companyService.createCompany(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    
    @GetMapping("/")
    public ResponseEntity<List<CompanyResponseDto>> getAllCompanies() {
        List<CompanyResponseDto> companies = companyService.getAllCompany();
        return ResponseEntity.status(HttpStatus.OK).body(companies);
    }
    
    
    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return  ResponseEntity.ok("Company deleted successfully");
    }
    
    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponseDto> getCompanyById(@PathVariable Long companyId) {

        return ResponseEntity.ok(companyService.findById(companyId));
    }
    
    
    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyResponseDto> updateCompany(
            @PathVariable Long companyId,
            @Valid @RequestBody CompanyRequestDto requestDto) {

        CompanyResponseDto response = companyService.updateCompany(companyId, requestDto);

        return ResponseEntity.ok(response);
    }
}
