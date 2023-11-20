package com.global.Services;

import java.util.List;

import com.global.Entity.User;

public interface DepartmentService {

	List<User> getAllUsers();
	
	User saveUser(User user);
	
	User updateUser (Long id,User user);
	
	void deleteUser(Long id);
	
	User getUser(Long id);
}
