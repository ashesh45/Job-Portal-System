package com.example.jobportal.seviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportal.dto.request.JobRequestDto;
import com.example.jobportal.dto.response.JobResponseDto;
import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private JobRepository jobRepo;

	@Override
	public JobResponseDto createJob(JobRequestDto dto) {
	    // Convert DTO to Entity
	    Job job = modelMapper.map(dto, Job.class);

	    // Save entity
	    Job savedJob = jobRepo.save(job);

	    // Convert Entity back to DTO
	    return modelMapper.map(savedJob, JobResponseDto.class);
	}

	@Override
	public JobResponseDto getJobById(Long jobId) {
		// TODO Auto-generated method stub

	    Job job = jobRepo.findById(jobId)
	            .orElseThrow(() -> new RuntimeException("Company not found with ID: " + jobId));

	    return modelMapper.map(job, JobResponseDto.class);
	}

	@Override
	public List<JobResponseDto> getAllJobs() {
		   return jobRepo.findAll()
		            .stream()
		            .map(job -> modelMapper.map(job, JobResponseDto.class))
		            .toList();
	}

	@Override
	public JobResponseDto updateJob(Long jobId, JobRequestDto dto) {
		  Job job = jobRepo.findById(jobId)
		            .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

		    // Copy DTO values to existing entity
		    modelMapper.map(dto, job);

		    Job updatedJob = jobRepo.save(job);

		    return modelMapper.map(updatedJob, JobResponseDto.class);
	}

	@Override
	public void deleteJob(Long jobId) {
		// TODO Auto-generated method stub
		 jobRepo.deleteById(jobId);
	}

}
