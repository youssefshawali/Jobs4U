package com.global.serviceImplement;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.UserProfile;
import com.global.Repository.UserProfileRepo;
import com.global.Services.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileRepo userProfileRepo;

	@Override
	public List<UserProfile> getAllUserProfiles() {
		// TODO Auto-generated method stub
		return userProfileRepo.findAll();
	}

	@Override
	public void deleteUserProfile(int id) {
		// TODO Auto-generated method stub
		userProfileRepo.deleteById(id);
	}

	@Override
	public UserProfile insertUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return userProfileRepo.save(userProfile);
	}

	@Override
	public UserProfile updateUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		UserProfile current = userProfileRepo.findById(userProfile.getId()).orElseThrow();

		current.setCurrentJobTitle(userProfile.getCurrentJobTitle());
		current.setBio(userProfile.getBio());
		current.setExperience(userProfile.getExperience());
		current.setCvFile(userProfile.getCvFile());
		current.setEducation(userProfile.getEducation());
//		current.setUser(userProfile.getUser());

		return userProfileRepo.save(current);
	}

	@Override
	public UserProfile getUserProfileById(int id) {
		// TODO Auto-generated method stub
		Optional<UserProfile> userProfile = userProfileRepo.findById(id);
		if (userProfile.isPresent()) {
			return userProfile.get();
		}
		throw new RuntimeException("UserProfile Not Fond");

	}

}
