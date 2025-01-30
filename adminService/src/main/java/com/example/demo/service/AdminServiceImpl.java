package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotFound;
import com.example.demo.repository.AdminRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	 
 AdminRepository repo;

	@Override
	public List<Admin> getAllAdmins() {
		return repo.findAll();
	}

	@Override
	public Admin getAdminById(int id) throws AdminNotFound {
		Optional<Admin> optional=repo.findById(id);
		if(optional.isPresent())
		return optional.get();
		else
			throw new  AdminNotFound("Admin not found with given Id!");
	
	}

	@Override
	public Admin createAdmin(Admin admin) {
		return repo.save(admin);
	}

	@Override
	 public Admin updateAdmin(int id, Admin adminDetails) throws AdminNotFound {
        Admin admin = repo.findById(id)
                .orElseThrow(() -> new AdminNotFound("Admin not found with id: " + id));
        admin.setUsername(adminDetails.getUsername());
        admin.setPassword(adminDetails.getPassword());
        admin.setEmail(adminDetails.getEmail());
        admin.setRole(adminDetails.getRole());
        return repo.save(admin);
    }

	@Override
	public String deleteAdmin(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
		// TODO Auto-generated method stub
		
	}

	  
}
