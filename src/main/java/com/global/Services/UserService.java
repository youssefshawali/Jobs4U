package com.global.Services;

import java.util.List;


import com.global.Entity.Education;
import com.global.Entity.User;
import com.global.Entity.UserProfile;

import org.springframework.stereotype.Service;
@Service
public interface UserService {
	
	UserProfile createUserProfile(int userId, UserProfile userProfile);
	
	List<User> getAllUsers();
	
	User insertUser(User user);
	
	User updateUser (User user);
	
	boolean deleteUser(int id);
	
	User getUserById(int id);

	String applyForJob(int userId, int jobId);

}
