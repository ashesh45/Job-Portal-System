package com.example.jobportal.service;

import java.util.List;

import com.example.jobportal.dto.request.JobApplicationRequestDto;
import com.example.jobportal.dto.response.JobApplicationResponseDto;
import com.example.jobportal.enumm.ApplicationStatus;

public interface JobApplicationService {

	 JobApplicationResponseDto applyJob(JobApplicationRequestDto dto);

	    List<JobApplicationResponseDto> getAllApplications();

	    JobApplicationResponseDto getApplicationById(Long id);

	    List<JobApplicationResponseDto> getApplicationsByApplicant(Integer applicantId);

	    List<JobApplicationResponseDto> getApplicationsByJob(Long jobId);

	    JobApplicationResponseDto updateStatus(
	            Long applicationId,
	            ApplicationStatus status);

	
}
