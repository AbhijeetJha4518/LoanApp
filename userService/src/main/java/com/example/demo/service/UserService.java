package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFound;

public interface UserService {
	public abstract String createUser(User user);

	public abstract List<User> getAllUsers();

	public abstract User getUserById(int id) throws UserNotFound;

	public abstract User updateUser(User user);

	public abstract String deleteUser(int id);
}
