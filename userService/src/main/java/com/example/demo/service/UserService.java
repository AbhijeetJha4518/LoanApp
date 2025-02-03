package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Loan;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;

public interface UserService {
	public abstract String createUser(User user);

	public abstract List<UserDTO> getAllUsers();

	public abstract UserDTO getUserById(int id) throws UserNotFound;

	public abstract UserDTO updateUser(User user);

	public abstract String deleteUser(int id);

	public abstract List<Loan> getLoan(int userId);
}
