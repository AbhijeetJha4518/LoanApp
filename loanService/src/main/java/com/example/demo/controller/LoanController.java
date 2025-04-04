package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;
import com.example.demo.service.LoanService;

import lombok.AllArgsConstructor;

/**
 * REST controller for managing loans. This class provides endpoints for
 * creating, retrieving, updating, and deleting loans.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/loan")
//@CrossOrigin(origins="http://localhost:4200")
public class LoanController {

	private LoanService service;

	/**
	 * Create a new loan.
	 * @param loan The loan entity to create.
	 * @return Success message.
	 */
	@PostMapping("/addLoan")
	public Loan createLoan(@RequestBody Loan loan) {
		return service.createLoan(loan);

	}

	/**
	 * Get all loans.
	 * @return List of all loans.
	 */
	@GetMapping("/getAllLoan")
	public List<Loan> getAllLoans() {
		return service.getAllLoans();

	}

	/**
	 * Get loan by ID.
	 * @param id The ID of the loan to fetch.
	 * @return The loan entity.
	 * @throws LoanNotFound if the loan with the specified ID is not found.
	 */
	@GetMapping("/getById/{id}")
	public Loan getLoanById(@PathVariable int id) throws LoanNotFound {
		return service.getLoanById(id);
	}

	/**
	 * Update loan details.
	 * @param id The ID of the loan to update.
	 * @param loanDetails The updated loan details.
	 * @return Success message.
	 * @throws LoanNotFound if the loan with the specified ID is not found.
	 */
	@PutMapping("update/{id}")
	public String updateLoan(@PathVariable int id, @RequestBody Loan loanDetails) throws LoanNotFound {
		try {
			service.updateLoan(id, loanDetails);
			return "Loan Updated Successfully!";
		} catch (LoanNotFound e) {
			return "No Loan with given Id!";
		}
	}

	/**
	 * Delete loan by ID 
	 * @param id The ID of the loan to delete.
	 * @return Success message.
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteLoan(@PathVariable int id) {
		return service.deleteLoan(id);

	}

	/**
	 * Get loans by user ID. This will get the loan details based on borrower's user
	 * ID.
	 * @param userId The user ID of the borrower.
	 * @return List of loans associated with the user ID.
	 */
	@GetMapping("/getLoanByUserId/{userId}")
	public List<Loan> getLoanByUserId(@PathVariable int userId) {
		return service.getLoanByUserId(userId);
	}

}