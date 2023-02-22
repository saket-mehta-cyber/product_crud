package com.edubridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.model.Admin;
import com.edubridge.service.AdminServiceImpl;

@RestController
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable Integer id){
		Admin admin= adminService.getAdmin(id);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		
	}
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin){
		adminService.addAdmin(admin);
		return new ResponseEntity<>("Admin has been registerd", HttpStatus.CREATED);
		
	}
	@PutMapping("/updateAdmin/{id}/{pass}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer id,@PathVariable String pass){
		Admin admin=adminService.updateAdminPassword(id, pass);
		if(admin==null) {
			return new ResponseEntity<>("Please give correct adminId", HttpStatus.BAD_REQUEST);	
		}
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
}
