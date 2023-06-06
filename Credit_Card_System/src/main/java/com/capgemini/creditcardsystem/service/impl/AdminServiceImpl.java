package com.capgemini.creditcardsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.creditcardsystem.dao.AdminDao;
import com.capgemini.creditcardsystem.dto.AdminDto;
import com.capgemini.creditcardsystem.exception.AdminNotFoundException;
import com.capgemini.creditcardsystem.model.Admin;
import com.capgemini.creditcardsystem.repository.AdminRepository;
import com.capgemini.creditcardsystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AdminDao dao;

	@Override
	public List<AdminDto> getAllAdmins() {

		List<Admin> admins = adminRepo.findAll();
		List<AdminDto> dto = admins.stream().map(admin -> modelMapper.map(admin, AdminDto.class))
				.collect(Collectors.toList());

		return dto;
	}

	@Override
	public AdminDto getAdminById(int adminId) {
		Optional<Admin> opt = adminRepo.findById(adminId);
		if (!opt.isPresent()) {
			throw new AdminNotFoundException();
		}
		return modelMapper.map(opt.get(), AdminDto.class);
	}

	@Override
	public AdminDto addAdmin(AdminDto admin) {
		Admin admins = modelMapper.map(admin, Admin.class);
		admins = dao.addAdmin(admins);
		return modelMapper.map(admins, AdminDto.class);
	}

}
