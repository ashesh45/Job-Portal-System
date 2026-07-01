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

import com.example.jobportal.dto.request.JobRequestDto;
import com.example.jobportal.dto.response.JobResponseDto;
import com.example.jobportal.service.JobService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/job")
public class JobController {
	
	
	@Autowired
	private JobService jobService;
	
    @PostMapping("/create")
    public ResponseEntity<JobResponseDto> createJob(@RequestBody JobRequestDto dto) {

        JobResponseDto response = jobService.createJob(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<JobResponseDto>> getAllJobs() {
        List<JobResponseDto> jobs = jobService.getAllJobs();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }
    
    
    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return  ResponseEntity.ok("Company deleted successfully");
    }
    
    
    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponseDto> getJobById(@PathVariable Long jobId) {
        return ResponseEntity.ok(jobService.getJobById(jobId));
    }
    
    
    @PutMapping("/{jobId}")
    public ResponseEntity<JobResponseDto> updateJob(
            @PathVariable Long jobId,
            @Valid @RequestBody JobRequestDto Dto) {

        JobResponseDto response = jobService.updateJob(jobId, Dto);

        return ResponseEntity.ok(response);
    }
}
