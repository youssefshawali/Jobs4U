package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Repository.UserProfileRepo;
import com.global.Repository.UserRepo;
import com.global.Services.UserProfileService;
import com.global.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserProfileService userProfileService;
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public UserProfile createUserProfile(int userId, UserProfile userProfile) {
        User user = getUserById(userId);
        userProfile.setUser(user);
        return userProfileService.insertUserProfile(userProfile);
    }
	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User current = userRepo.findById(user.getId()).orElseThrow();

		current.setFname(user.getFname());
		current.setLname(user.getLname());
		current.setPhoneNumber(user.getPhoneNumber());
		current.setEmail(user.getEmail());
		current.setPassword(user.getPassword());
		current.setAge(user.getAge());
		current.setProfilePicture(user.getProfilePicture());
		current.setUserProfile(user.getUserProfile());
		current.setAppliedJobs(user.getAppliedJobs());

		return userRepo.save(current);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("User Not Fond");

	}

}
