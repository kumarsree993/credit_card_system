package com.capgemini.creditcardsystem.service;

import java.util.List;

import com.capgemini.creditcardsystem.dto.AdminDto;

public interface AdminService {

	List<AdminDto> getAllAdmins();

	AdminDto getAdminById(int adminId);

	AdminDto addAdmin(AdminDto admin);

}
