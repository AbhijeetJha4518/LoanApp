package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotFound;
import com.example.demo.mapper.AdminMapper;
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
	public AdminDTO getAdminById(int id) throws AdminNotFound {
		Admin admin=repo.findById(id).orElse(null);
		if(admin == null) {
			throw new  AdminNotFound("Admin not found with given Id!");
		}
		AdminDTO dto = AdminMapper.mapToAdminDTO(admin); 
//		AdminDTO dto = new AdminDTO(admin.getId(),admin.getName(),admin.getEmail());
		return dto; 
			
	
	}

	@Override
	public Admin createAdmin(Admin admin) {
		return repo.save(admin);
	}

	@Override
	 public Admin updateAdmin(int id, Admin adminDetails) throws AdminNotFound {
        Admin admin = repo.findById(id)
                .orElseThrow(() -> new AdminNotFound("Admin not found with id: " + id));
        admin.setName(adminDetails.getName());
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
