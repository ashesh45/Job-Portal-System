package com.example.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
	

	   List<JobApplication> findByJob_JobId(Long jobId);

	    List<JobApplication> findByApplicant_UserId(Integer userId);

	    boolean existsByApplicant_UserIdAndJob_JobId(Integer userId, Long jobId);

}
