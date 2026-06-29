package com.example.jobportal.dto;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
	
    private Long companyId;
    private String companyName;
    private String companyEmail;
    private String phoneNumber;
    private String website;
   
    private String city;
    private String state;
 
    private String postalCode;
    private int foundedYear;
    private int employeeSize;
    private String registrationNumber;
    private String taxNumber;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

	 //   private String companyLogo;

}
