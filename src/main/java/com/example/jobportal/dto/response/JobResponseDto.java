package com.example.jobportal.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.jobportal.model.Company;
import com.example.jobportal.model.Job;
import com.example.jobportal.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponseDto {
	

   private Long jobId;

    private String jobTitle;

    private String jobDescription;

    private String jobType; // Full Time, Part Time, Internship, Contract
  
    private String workMode; // Remote, Hybrid, On-site
    
    private String location;

    private String experience; // Fresher, Junior, Mid, Senior

    private Integer vacancies;

    private String skills; // Java, Spring Boot, MySQL

    private LocalDate applicationDeadline;

    private Boolean active = true;

}
