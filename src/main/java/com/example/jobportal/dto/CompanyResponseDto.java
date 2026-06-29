package com.example.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDto {
	
	  private Long companyId;

	    private String companyName;

	    private String companyEmail;

	    private String phoneNumber;

	    private String website;
	
	    private String city;

	    private String state;

	    private String postalCode;

}
