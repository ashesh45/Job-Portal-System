package com.example.jobportal.seviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportal.dto.request.CompanyRequestDto;
import com.example.jobportal.dto.response.CompanyResponseDto;
import com.example.jobportal.model.Company;
import com.example.jobportal.repository.CompanyRepository;
import com.example.jobportal.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CompanyResponseDto createCompany(CompanyRequestDto dto) {

	    // Convert DTO to Entity
	    Company company = modelMapper.map(dto, Company.class);

	    // Save entity
	    Company savedCompany = companyRepo.save(company);

	    // Convert Entity back to DTO
	    return modelMapper.map(savedCompany, CompanyResponseDto.class);
	}

	@Override
	public CompanyResponseDto findById(Long companyId) {

	    Company company = companyRepo.findById(companyId)
	            .orElseThrow(() -> new RuntimeException("Company not found with ID: " + companyId));

	    return modelMapper.map(company, CompanyResponseDto.class);
	}


	@Override
	public List<CompanyResponseDto> getAllCompany() {
	    return companyRepo.findAll()
	            .stream()
	            .map(company -> modelMapper.map(company, CompanyResponseDto.class))
	            .toList();
	}

@Override
public void deleteCompany(Long companyId) {
	// TODO Auto-generated method stub
	 companyRepo.deleteById(companyId);
}

@Override
public CompanyResponseDto updateCompany(Long companyId, CompanyRequestDto requestdto) {
	   Company company = companyRepo.findById(companyId)
	            .orElseThrow(() -> new RuntimeException("Company not found with ID: " + companyId));

	    // Copy DTO values to existing entity
	    modelMapper.map(requestdto, company);

	    Company updatedCompany = companyRepo.save(company);

	    return modelMapper.map(updatedCompany, CompanyResponseDto.class);
}

}
