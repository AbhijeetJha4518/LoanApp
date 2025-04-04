package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Loan. This class is mapped to the database table
 * for storing loan details.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

	// Unique identifier for the loan, auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Type of the loan, must be between 2 and 50 characters
	@NotEmpty(message = "Loan type cannot be empty")
	@Size(min = 2, max = 50, message = "Loan type must be between 2 and 50 characters")
	private String loanType;

	// Amount of the loan, must be greater than zero
	@NotNull(message = "Loan amount cannot be null")
	@Min(value = 1, message = "Loan amount must be greater than zero")
	private Double loanAmount;

	// Term of the loan, must be between 1 and 20 characters
	@NotEmpty(message = "Loan term cannot be empty")
	@Size(min = 1, max = 20, message = "Loan term must be between 1 and 20 characters")
	private String loanTerm;

	// Interest rate of the loan, must be non-negative
	@NotNull(message = "Interest rate cannot be null")
	@Min(value = 0, message = "Interest rate must be non-negative")
	private Double interestRate;
	
	private String status;

	// User ID of the borrower
	@NotNull
	private int userId;
}