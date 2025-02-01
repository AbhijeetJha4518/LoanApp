package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminNotFound;

public interface AdminService {

   public abstract List<Admin> getAllAdmins();

   
   
   public abstract AdminDTO getAdminById(int id) throws AdminNotFound;

   public abstract Admin createAdmin(Admin admin);

   public abstract Admin updateAdmin(int id, Admin adminDetails) throws AdminNotFound;

   public abstract String deleteAdmin(int id);

}
