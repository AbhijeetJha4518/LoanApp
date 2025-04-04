package com.example.demo;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Loan;
import com.example.demo.exception.LoanNotFound;
import com.example.demo.repository.LoanRepository;
import com.example.demo.service.LoanServiceImpl;

@SpringBootTest
class LoanServiceApplicationTests {


    @Mock
    private LoanRepository repo;

    @InjectMocks
    private LoanServiceImpl loanService;

    private Loan loan;

    @BeforeEach
    void setUp() {
        loan = new Loan();
        loan.setId(1);
        loan.setUserId(1);
        loan.setLoanType("car");
        loan.setLoanTerm("12");
        loan.setInterestRate(5.5);
    }

    @Test
    void testCreateLoan() {
        when(repo.save(loan)).thenReturn(loan);
        Loan result = loanService.createLoan(loan);
        assertEquals(loan, result);
    }

    @Test
    void testGetAllLoans() {
        when(repo.findAll()).thenReturn(Arrays.asList(loan));
        List<Loan> loans = loanService.getAllLoans();
        assertEquals(1, loans.size());
        assertEquals(loan, loans.get(0));
    }

    @Test
    void testGetLoanById() throws LoanNotFound {
        when(repo.findById(1)).thenReturn(Optional.of(loan));
        Loan result = loanService.getLoanById(1);
        assertEquals(loan, result);
    }

    @Test
    void testGetLoanById_LoanNotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());
        assertThrows(LoanNotFound.class, () -> loanService.getLoanById(1));
    }

    @Test
    void testUpdateLoan() throws LoanNotFound {
        Loan updatedLoan = new Loan();
        updatedLoan.setId(1);
        updatedLoan.setUserId(1);
        updatedLoan.setLoanType("Home");
        updatedLoan.setLoanAmount(20000d);
        updatedLoan.setLoanTerm("24");
        updatedLoan.setInterestRate(4.5);

        when(repo.findById(1)).thenReturn(Optional.of(loan));
        when(repo.save(loan)).thenReturn(updatedLoan);

        Loan result = loanService.updateLoan(1, updatedLoan);
        assertEquals(updatedLoan, result);
    }

    @Test
    void testUpdateLoan_LoanNotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());
        Loan updatedLoan = new Loan();
        updatedLoan.setId(1);
        updatedLoan.setUserId(1);
        updatedLoan.setLoanType("Home");
        updatedLoan.setLoanAmount(20000d);
        updatedLoan.setLoanTerm("24");
        updatedLoan.setInterestRate(4.5);

        assertThrows(LoanNotFound.class, () -> loanService.updateLoan(1, updatedLoan));
    }

    @Test
    void testDeleteLoan() {
        String result = loanService.deleteLoan(1);
        assertEquals("Loan Deleted Successfully", result);
    }

    @Test
    void testGetLoanByUserId() {
        when(repo.findLoanByUserId(1)).thenReturn(Arrays.asList(loan));
        List<Loan> loans = loanService.getLoanByUserId(1);
        assertEquals(1, loans.size());
        assertEquals(loan, loans.get(0));
    }
}
