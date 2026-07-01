package com.example.jobportal.dto.response;

import java.time.LocalDate;

import com.example.jobportal.enumm.ApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationResponseDto {
	
	private Long id;

    private LocalDate appliedDate;

    private ApplicationStatus status;

    private String coverLetter;

    private String resumeUrl;

    private String applicantEmail;

}
