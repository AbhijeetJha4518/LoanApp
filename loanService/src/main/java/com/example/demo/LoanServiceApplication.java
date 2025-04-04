package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Loan Service application.
 * This class is the entry point for the Spring Boot application.
 */
@SpringBootApplication
public class LoanServiceApplication {

    /**
     * Main method to run the Spring Boot application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(LoanServiceApplication.class, args);
    }
}