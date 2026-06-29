package com.example.jobportal.service;

import java.util.List;

import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.dto.CompanyResponseDto;

public interface CompanyService {
    CompanyResponseDto createCompany(CompanyDto dto);

    CompanyDto getCompanyById(int id);

    List<CompanyDto> getAllCompany();

    CompanyDto updateCompany(int id, CompanyDto dto);

    void deleteCompany(int id);

}
