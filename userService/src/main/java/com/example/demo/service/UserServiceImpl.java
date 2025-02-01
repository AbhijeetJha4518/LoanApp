package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Loan;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
import com.example.demo.external_services.LoanServices;
//import com.example.demo.exception.UserNotFound;
import com.example.demo.repository.UserServiceRepo;

import lombok.AllArgsConstructor;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserServiceRepo repo;

	@Autowired
	LoanServices loanServices;

	@Override
	public String createUser(User user) {
		User user1 = repo.save(user);
		if (user1 != null)
			return "Product Saved Successfully";
		else
			return "Failed to save Product";
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User getUserById(int id) throws UserNotFound {
		User optional = repo.findById(id).orElse(null); // findById provide optional product to avoid null point error
		if (optional == null) {
			throw new UserNotFound("User not found ");
		}

		return optional;

	}

	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}

	@Override
	public String deleteUser(int id) {
		repo.deleteById(id);
		return "Product Deleted Successfully";
	}

	@Override
	public List<Loan> getLoan(int userId) {
		return loanServices.getLoanByUserId(userId);
	}

}
