package com.example.demo.comtroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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

@RestController
@AllArgsConstructor
@RequestMapping("/loan") // http//:
public class LoanController {

	private LoanService service;

	@PostMapping("/addLoan")
	public String createLoan(@RequestBody Loan loan) {
		return service.createLoan(loan);

	}

	@GetMapping("/getAllLoan")
	public List<Loan> getAllLoans() {
		return service.getAllLoans();

	}

	@GetMapping("/getById/{id}")
	public Loan getLoanById(@PathVariable int id) throws LoanNotFound {
		return service.getLoanById(id);
	}

	@PutMapping("update/{id}")
	public String updateLoan(@PathVariable int id, @RequestBody Loan loanDetails) throws LoanNotFound {
		try {
			service.updateLoan(id, loanDetails);
			return "Loan Updated Successfully!";
		} catch (LoanNotFound e) {
			return "No Loan with given Id!";
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteLoan(@PathVariable int id) {
		return service.deleteLoan(id);

	}

}
