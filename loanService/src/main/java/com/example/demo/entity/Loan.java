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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Loan type cannot be empty")
    @Size(min = 2, max = 50, message = "Loan type must be between 2 and 50 characters")
    private String loanType;

    @NotNull(message = "Loan amount cannot be null")
    @Min(value = 1, message = "Loan amount must be greater than zero")
    private Double loanAmount;

    @NotEmpty(message = "Loan term cannot be empty")
    @Size(min = 1, max = 20, message = "Loan term must be between 1 and 20 characters")
    private String loanTerm;

    @NotNull(message = "Interest rate cannot be null")
    @Min(value = 0, message = "Interest rate must be non-negative")
    private Double interestRate;

    @NotNull
    private int userId;
}