package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;
import com.example.demo.repository.LoanRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

	LoanRepository repo;

	@Override
	public String createLoan(Loan loan) {
		Loan loan1 = repo.save(loan);
		if (loan1 != null)
			return "Loan Saved Successfully";
		else
			return "Failed to save Loan";
	}

	@Override
	public List<Loan> getAllLoans() {
		return repo.findAll();
	}

	@Override
	public Loan getLoanById(int id) throws LoanNotFound {
		Optional<Loan> optional = repo.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			throw new LoanNotFound("No loan found with given ID!");

	}

	@Override
	public Loan updateLoan(int id, Loan loanDetails) throws LoanNotFound {
		Optional<Loan> optionalLoan = repo.findById(id);
		if (optionalLoan.isPresent()) {
			Loan loan = optionalLoan.get();
			loan.setLoanType(loanDetails.getLoanType());
			loan.setLoanAmount(loanDetails.getLoanAmount());
			loan.setLoanTerm(loanDetails.getLoanTerm());
			loan.setInterestRate(loanDetails.getInterestRate());
			return repo.save(loan);
		} else {
			throw new LoanNotFound("Loan not found with id " + id);
		}
	}

	@Override
	public String deleteLoan(int id) {
		repo.deleteById(id);
		return "Loan Deleted Successfully";

	}

	@Override
	public List<Loan> getLoanByUserId(int userId) {
		return repo.findLoanByUserId(userId);
	}

}
