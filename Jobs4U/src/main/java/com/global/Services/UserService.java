package com.global.Services;

import java.util.List;

import com.global.Entity.User;


public interface UserService {
	
	
	List<User> getAllUsers();
	
	User insertUser(User user);
	
	User updateUser (User user);
	
	void deleteUser(Long id);
	
	User findUserById(Long id);

}
