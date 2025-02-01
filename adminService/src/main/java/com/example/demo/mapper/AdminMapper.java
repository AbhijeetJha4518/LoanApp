package com.example.demo.mapper;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;

public class AdminMapper {
	public static AdminDTO mapToAdminDTO(Admin admin) {
		return new AdminDTO(
				admin.getId(),
				admin.getName(),
				admin.getEmail(),
				admin.getRole()
				);
	}
}
