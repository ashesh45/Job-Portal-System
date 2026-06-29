package com.example.jobportal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long companyId;

	    @NotBlank(message = "Company name is required")
	    @Column(nullable = false, unique = true)
	    private String companyName;

	    @NotBlank(message = "Company email is required")
	    @Email(message = "Invalid email")
	    @Column(nullable = false, unique = true)
	    private String companyEmail;

	    @NotBlank(message = "Phone number is required")
	    @Column(nullable = false)
	    private String phoneNumber;

	    @NotBlank(message = "Website is required")
	    private String website;


	    private String city;

	    private String state;


	    private String postalCode;

	   // private String companyLogo;

	    private int foundedYear;

	    private int employeeSize;

	    private String registrationNumber;

	    private String taxNumber;

	    @Column(updatable = false)
	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

	    @PrePersist
	    public void prePersist() {
	        createdAt = LocalDateTime.now();
	        updatedAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    public void preUpdate() {
	        updatedAt = LocalDateTime.now();
	    }

	
}
