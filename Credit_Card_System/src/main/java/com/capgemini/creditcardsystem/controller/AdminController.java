package com.capgemini.creditcardsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.creditcardsystem.dto.AdminDto;
import com.capgemini.creditcardsystem.service.AdminService;

@RestController
@RequestMapping("/adminapi")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admins")
	public ResponseEntity<List<AdminDto>> getAllAdmins() {

		List<AdminDto> admins = null;
		ResponseEntity<List<AdminDto>> allAdmins = null;

		try {
			admins = adminService.getAllAdmins();
			if (!admins.isEmpty()) {
				allAdmins = new ResponseEntity<>(admins, HttpStatus.FOUND);
			} else {
				allAdmins = new ResponseEntity<>(admins, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			allAdmins = new ResponseEntity<>(admins, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return allAdmins;

	}

	@GetMapping("/admins/{adminId}")
	public ResponseEntity<AdminDto> getAdminById(@PathVariable int adminId) {

		AdminDto admin = null;
		ResponseEntity<AdminDto> admn = null;
		try {
			admin = adminService.getAdminById(adminId);
			if (admin != null) {
				admn = new ResponseEntity<>(admin, HttpStatus.FOUND);
			} else {
				admn = new ResponseEntity<>(admin, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			admn = new ResponseEntity<>(admin, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return admn;
	}

	@PostMapping("/admins")
	public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto admin) {

		return new ResponseEntity<AdminDto>(adminService.addAdmin(admin), HttpStatus.CREATED);
	}

}
