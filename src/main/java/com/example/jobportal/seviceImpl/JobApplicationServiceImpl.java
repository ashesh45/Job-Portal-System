package com.example.jobportal.seviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.dto.request.JobApplicationRequestDto;
import com.example.jobportal.dto.response.JobApplicationResponseDto;
import com.example.jobportal.enumm.ApplicationStatus;
import com.example.jobportal.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	@Override
	public JobApplicationResponseDto applyJob(JobApplicationRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobApplicationResponseDto> getAllApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplicationResponseDto getApplicationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobApplicationResponseDto> getApplicationsByApplicant(Integer applicantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobApplicationResponseDto> getApplicationsByJob(Long jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplicationResponseDto updateStatus(Long applicationId, ApplicationStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

}
