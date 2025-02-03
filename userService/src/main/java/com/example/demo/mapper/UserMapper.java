package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public class UserMapper {
	public static UserDTO mapToUserDTO(User user) {
		return new UserDTO(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getPhoneNumber(),
				user.getAddress()
				);
	}

}
