package com.capgemini.creditcardsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.creditcardsystem.model.Admin;
import com.capgemini.creditcardsystem.repository.AdminRepository;

@Component
public class AdminDao {

	@Autowired
	AdminRepository adminRepo;
	
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
}
