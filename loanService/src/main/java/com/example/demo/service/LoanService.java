package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;

/**
 * Service interface for Loan operations.
 * This interface defines the methods for managing Loan entities and related operations.
 */
public interface LoanService {

    /**
     * Creates a new loan.
     * @param loan The Loan entity to create.
     * @return Success message indicating whether the loan was saved successfully.
     */
    public abstract Loan createLoan(Loan loan);

    /**
     * Fetches all loans.
     * @return List of all Loan entities.
     */
    public abstract List<Loan> getAllLoans();

    /**
     * Fetches a loan by ID.
     * @param id The ID of the loan to fetch.
     * @return The Loan entity.
     * @throws LoanNotFound if the loan with the specified ID is not found.
     */
    public abstract Loan getLoanById(int id) throws LoanNotFound;

    /**
     * Updates an existing loan.
     * @param id The ID of the loan to update.
     * @param loanDetails The updated loan details.
     * @return The updated Loan entity.
     * @throws LoanNotFound if the loan with the specified ID is not found.
     */
    public abstract Loan updateLoan(int id, Loan loanDetails) throws LoanNotFound;

    /**
     * Deletes a loan by ID.
     * @param id The ID of the loan to delete.
     * @return Success message indicating the loan was deleted.
     */
    public abstract String deleteLoan(int id);

    /**
     * Fetches loans by user ID.
     * @param userId The ID of the user to find loans for.
     * @return List of loans associated with the specified user ID.
     */
    List<Loan> getLoanByUserId(int userId);
}