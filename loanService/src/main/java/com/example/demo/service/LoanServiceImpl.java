package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;
import com.example.demo.repository.LoanRepository;

import lombok.AllArgsConstructor;

/**
 * Implementation of the LoanService interface.
 * This class provides the actual implementation of the methods defined in the LoanService interface.
 */
@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    // Repository for Loan entities
    LoanRepository repo;

    /**
     * Creates a new loan.
     * @param loan The Loan entity to create.
     * @return Success message indicating whether the loan was saved successfully.
     */
    @Override
    public Loan createLoan(Loan loan) {
        return repo.save(loan);
        
    }

    /**
     * Fetches all loans.
     * @return List of all Loan entities.
     */
    @Override
    public List<Loan> getAllLoans() {
        return repo.findAll();
    }

    /**
     * Fetches a loan by ID.
     * @param id The ID of the loan to fetch.
     * @return The Loan entity.
     * @throws LoanNotFound if the loan with the specified ID is not found.
     */
    @Override
    public Loan getLoanById(int id) throws LoanNotFound {
        Optional<Loan> optional = repo.findById(id);
        if (optional.isPresent())
            return optional.get();
        else
            throw new LoanNotFound("No loan found with given ID!");
    }

    /**
     * Updates an existing loan.
     * @param id The ID of the loan to update.
     * @param loanDetails The updated loan details.
     * @return The updated Loan entity.
     * @throws LoanNotFound if the loan with the specified ID is not found.
     */
    @Override
    public Loan updateLoan(int id, Loan loanDetails) throws LoanNotFound {
        Optional<Loan> optionalLoan = repo.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setLoanType(loanDetails.getLoanType());
            loan.setLoanAmount(loanDetails.getLoanAmount());
            loan.setLoanTerm(loanDetails.getLoanTerm());
            loan.setInterestRate(loanDetails.getInterestRate());
            loan.setStatus(loanDetails.getStatus());
            return repo.save(loan);
        } else {
            throw new LoanNotFound("Loan not found with id " + id);
        }
    }

    /**
     * Deletes a loan by ID.
     * @param id The ID of the loan to delete.
     * @return Success message indicating the loan was deleted.
     */
    @Override
    public String deleteLoan(int id) {
        repo.deleteById(id);
        return "Loan Deleted Successfully";
    }

    /**
     * Fetches loans by user ID.
     * @param userId The ID of the user to find loans for.
     * @return List of loans associated with the specified user ID.
     */
    @Override
    public List<Loan> getLoanByUserId(int userId) {
        return repo.findLoanByUserId(userId);
    }
}