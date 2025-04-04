package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

/**
 * Repository interface for Loan entity.
 * This interface extends JpaRepository to provide CRUD operations for Loan entities.
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    /**
     * Custom query method to find loans by user ID.
     * @param userId The ID of the user to find loans for.
     * @return List of loans associated with the specified user ID.
     */
    List<Loan> findLoanByUserId(int userId);
}