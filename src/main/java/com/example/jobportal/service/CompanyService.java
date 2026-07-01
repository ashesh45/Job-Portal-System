package com.example.jobportal.service;

import java.util.List;

import com.example.jobportal.dto.request.CompanyRequestDto;
import com.example.jobportal.dto.response.CompanyResponseDto;

public interface CompanyService {
    CompanyResponseDto createCompany(CompanyRequestDto dto);

    CompanyResponseDto findById(Long companyId);

    List<CompanyResponseDto> getAllCompany();

    CompanyResponseDto updateCompany(Long companyId, CompanyRequestDto requestdto);

    void deleteCompany(Long companyId);

}
