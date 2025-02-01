package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	private int id;
	private String loanType;
	private Double loanAmount;
	private String loanTerm;
	private Double interestRate;
	private int userId;
}
