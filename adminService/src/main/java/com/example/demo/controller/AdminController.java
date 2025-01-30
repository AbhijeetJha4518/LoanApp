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

import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotFound;
import com.example.demo.service.AdminService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	
	 
	    private AdminService service;

	    @GetMapping("/getAll")
	  public List<Admin> AllAdmins() {
	        return service.getAllAdmins();
	    }

	    @GetMapping("/getById/{id}")
	    public Admin getAdminById(@PathVariable int id) throws AdminNotFound{
	        return service.getAdminById(id);

	    }

	    @PostMapping("/save")
	    public Admin createAdmin(@Valid @RequestBody Admin admin) {
	        return service.createAdmin(admin);
	    }
	    @PutMapping("/update/{id}")
	   public String updateAdmin(@PathVariable int id, @Valid @RequestBody Admin adminDetails) throws AdminNotFound {
	        service.updateAdmin(id, adminDetails);
	        return "Adimin detail updated";
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
	        service.deleteAdmin(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    

}
