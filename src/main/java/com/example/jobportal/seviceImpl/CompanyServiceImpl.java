package com.example.jobportal.seviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportal.dto.CompanyDto;
import com.example.jobportal.dto.CompanyResponseDto;
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
	public CompanyResponseDto createCompany(CompanyDto dto) {

	    // Convert DTO to Entity
	    Company company = modelMapper.map(dto, Company.class);

	    // Save entity
	    Company savedCompany = companyRepo.save(company);

	    // Convert Entity back to DTO
	    return modelMapper.map(savedCompany, CompanyResponseDto.class);
	}

	@Override
	public CompanyDto getCompanyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyDto> getAllCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyDto updateCompany(int id, CompanyDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		
	}

}
