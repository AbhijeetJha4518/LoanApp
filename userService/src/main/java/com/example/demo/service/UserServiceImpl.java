package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;
//import com.example.demo.exception.UserNotFound;
import com.example.demo.repository.UserServiceRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	UserServiceRepo repo;

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
		Optional<User> optional = repo.findById(id); // findById provide optional product to avoid null point error
		if (optional.isPresent())
			return optional.get();
		else
			throw new UserNotFound("No Product Found with given ID!!");

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

}
