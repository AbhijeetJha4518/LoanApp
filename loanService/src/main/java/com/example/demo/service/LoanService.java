package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;

public interface LoanService {
	public abstract String createLoan(Loan loan);

	public abstract List<Loan> getAllLoans();

	public abstract Loan getLoanById(int id) throws LoanNotFound;

	public abstract Loan updateLoan(int id, Loan loanDetails) throws LoanNotFound;

	public abstract String deleteLoan(int id);

}
