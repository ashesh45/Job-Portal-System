package com.example.jobportal.dto.request;
import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobRequestDto {
	
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
	    private Long companyId;
	    private Long employerId;


}
