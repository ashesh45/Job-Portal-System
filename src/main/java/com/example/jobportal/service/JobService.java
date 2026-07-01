package com.example.jobportal.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import com.example.jobportal.dto.request.JobRequestDto;
import com.example.jobportal.dto.response.JobResponseDto;


public interface JobService {
	
    JobResponseDto createJob(JobRequestDto dto);

    JobResponseDto getJobById(Long jobId);

    List<JobResponseDto> getAllJobs();

    JobResponseDto updateJob(Long jobId, JobRequestDto dto);

    void deleteJob(Long jobId);


}
