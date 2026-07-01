package com.example.jobportal.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.jobportal.enumm.JobStatus;
import com.example.jobportal.enumm.JobType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long jobId;

	    @NotBlank(message = "Job title is required")
	    @Column(nullable = false)
	    private String jobTitle;

	    @Column(columnDefinition = "TEXT")
	    private String jobDescription;

	    @Enumerated(EnumType.STRING)
	    private JobType jobType;

	    @NotBlank(message = "Work mode is required")
	    private String workMode; // Remote, Hybrid, On-site

	    @NotBlank(message = "Location is required")
	    private String location;

	    private String experience; // Fresher, Junior, Mid, Senior

	    private Integer vacancies;

	    private String skills; // Java, Spring Boot, MySQL

	    private LocalDate applicationDeadline;

	    @Enumerated(EnumType.STRING)
	    private JobStatus jobStatus;

	    @Column(updatable = false)
	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

	    // Many jobs belong to one company
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "company_id")
	    @JsonBackReference
	    private Company company;

	    // Many jobs created by one employer(User)
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "employer_id")
	    private User employer;

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
