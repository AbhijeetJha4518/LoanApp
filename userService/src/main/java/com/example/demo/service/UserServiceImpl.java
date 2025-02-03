package com.example.demo.service;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Loan;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
import com.example.demo.external_services.LoanServices;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserServiceRepo;

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
	public List<UserDTO> getAllUsers() {
		List<User>users=repo.findAll();
		List<UserDTO> userDTO= users.stream().map(user->UserMapper.mapToUserDTO(user)).toList();
		return userDTO;
	}

	@Override
	public UserDTO getUserById(int id) throws UserNotFound {
		User user = repo.findById(id).orElse(null); // findById provide optional product to avoid null point error
		if (user == null) {
			throw new UserNotFound("User not found ");
		}

		UserDTO dto= UserMapper.mapToUserDTO(user);
		return dto;

	}

	@Override
	public UserDTO updateUser(User user) {
		User updatedUser = repo.save(user);
		UserDTO userDTO = UserMapper.mapToUserDTO(updatedUser);
		return userDTO;
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
