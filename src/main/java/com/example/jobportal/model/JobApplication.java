package com.example.jobportal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.jobportal.enumm.ApplicationStatus;

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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "job_applications")
public class JobApplication {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate appliedDate;

	    @Enumerated(EnumType.STRING)
	    private ApplicationStatus status;

	    private String resumeUrl;

	    @Column(length = 2000)
	    private String coverLetter;
	    
	    private String email;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "job_id")
	    private Job job;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "applicant_id")
	    private User applicant;
	    
	    @CreationTimestamp
	    private LocalDateTime createdAt;

	    @UpdateTimestamp
	    private LocalDateTime updatedAt;

}
