package com.global.Services;

import java.util.List;

import com.global.Entity.Education;
import com.global.Entity.Experience;
import com.global.Entity.Skill;
import com.global.Entity.UserProfile;

import org.springframework.stereotype.Service;
@Service
public interface UserProfileService {
	
	Experience createExperience(int profileId, Experience experience);
	
	List<UserProfile> getAllUserProfiles();
	
	UserProfile insertUserProfile(UserProfile userProfile);
	
	UserProfile updateUserProfile (UserProfile userProfile);
	
	void deleteUserProfile(int id);
	
	UserProfile getUserProfileById(int id);

	Education createEducation(int profileId, Education education);

	UserProfile createSkill(int profileId, List<Skill> skill);

}
