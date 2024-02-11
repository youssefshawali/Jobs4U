package com.global.Services;

import java.util.List;

import com.global.Entity.UserProfile;


public interface UserProfileService {
	
	
	List<UserProfile> getAllUserProfiles();
	
	UserProfile insertUserProfile(UserProfile userProfile);
	
	UserProfile updateUserProfile (UserProfile userProfile);
	
	void deleteUserProfile(int id);
	
	UserProfile getUserProfileById(int id);

}
