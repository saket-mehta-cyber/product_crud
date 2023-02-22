package com.edubridge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.model.Admin;
import com.edubridge.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;

	@Override
	public void addAdmin(Admin admin) {
		repository.save(admin);

	}

	@Override
	public Admin getAdmin(Integer adminId) {
		Optional<Admin> admin = repository.findById(adminId);
		return admin.get();
	}

	@Override
	public Admin getAdminByName(String name) {
		Optional<Admin> admin = repository.findByUserName(name);
		return admin.get();
	}

	@Override
	public Admin updateAdminPassword(Integer id, String newPassword) {
		Optional<Admin> optionalAdmin = repository.findById(id);
		Admin admin = optionalAdmin.get();
		if (admin != null) {
			admin.setPassword(newPassword);
		}
		repository.save(admin);
		return admin == null ? null : repository.findById(id).get();
	}

	@Override
	public void deleteAdmin(Integer id) {
		repository.deleteById(id);

	}

}
