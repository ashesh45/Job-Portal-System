package com.example.jobportal.dto.request;

import java.time.LocalDate;

import com.example.jobportal.dto.response.JobResponseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationRequestDto {
	

    @NotNull
    private Long jobId;

    @NotBlank
    private String coverLetter;

    private String resumeUrl;

}
