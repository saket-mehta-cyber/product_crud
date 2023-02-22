package com.edubridge.service;

import com.edubridge.model.Admin;

public interface AdminService {

	public void addAdmin(Admin admin);
	public Admin getAdmin(Integer adminId);
	public Admin getAdminByName(String name);
	public Admin updateAdminPassword(Integer id, String password);
	public void deleteAdmin(Integer id);
	
}
