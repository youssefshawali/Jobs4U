package com.global.Services;

import java.util.List;

import com.global.Entity.Education;
import com.global.Entity.User;
import com.global.Entity.UserProfile;


public interface UserService {
	
	UserProfile createUserProfile(int userId, UserProfile userProfile);
	
	List<User> getAllUsers();
	
	User insertUser(User user);
	
	User updateUser (User user);
	
	void deleteUser(int id);
	
	User getUserById(int id);

}
