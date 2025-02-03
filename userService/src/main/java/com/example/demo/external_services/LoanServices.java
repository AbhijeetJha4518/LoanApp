package com.example.demo.external_services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Loan;

@FeignClient(name="LoanService" , url = "http://LOANSERVICE/loan")
public interface LoanServices {
	@GetMapping("/getLoanByUserId/{userId}")
	public List<Loan> getLoanByUserId(@PathVariable int userId);
}
