package com.example.demo.controller;

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

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Loan;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

	UserService service;

	@PostMapping("/save") // http://localhost:5003/users/save
	public String saveUser(@Valid @RequestBody User user) {
		return service.createUser(user);

	}

	@GetMapping("/getAllUsers")
	public List<UserDTO> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/getById/{id}")
	public UserDTO getUserById(@PathVariable int id) throws UserNotFound {
		return service.getUserById(id);
		

	}

	@PutMapping("/update") // http://localhost:5003/users/update
	public UserDTO updateUser(@Valid @RequestBody User user) {
		return service.updateUser(user);

	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}

	@GetMapping("/findLoanByUserId/{userId}")
	public List<Loan> getLoan(@PathVariable int userId) {
		return service.getLoan(userId);
	}
}
