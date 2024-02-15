package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Education;
import com.global.Entity.Experience;
import com.global.Entity.Skill;
import com.global.Entity.UserProfile;
import com.global.Repository.UserProfileRepo;
import com.global.Services.EducationService;
import com.global.Services.ExperienceService;
import com.global.Services.SkillService;
import com.global.Services.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileRepo userProfileRepo;
	@Autowired
	ExperienceService experienceService;
	@Autowired
	EducationService educationService;
	@Autowired
	SkillService skillService;

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
		try {
			UserProfile current = userProfileRepo.findById(userProfile.getId()).orElseThrow();
			if (userProfile.getCurrentJobTitle() != null) {
				current.setCurrentJobTitle(userProfile.getCurrentJobTitle());
			}
			if (userProfile.getBio() != null) {
				current.setBio(userProfile.getBio());
			}
			if (userProfile.getExperience() != null) {
				current.setExperience(userProfile.getExperience());
			}
			if (userProfile.getCvFile() != null) {
				current.setCvFile(userProfile.getCvFile());
			}
			if (userProfile.getEducation() != null) {
				current.setEducation(userProfile.getEducation());
			}
//		current.setUser(userProfile.getUser());

			return userProfileRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("UserProfile not found for ID: " + userProfile.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update userProfile", e);
		}
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

	// Experience
	@Override
	public Experience createExperience(int profileId, Experience experience) {
		UserProfile userProfile = getUserProfileById(profileId);
		experience.setUserProfile(userProfile);
		return experienceService.insertExperience(experience);
	}

	// Education
	@Override
	public Education createEducation(int profileId, Education education) {
		UserProfile userProfile = getUserProfileById(profileId);
		education.setUserProfile(userProfile);
		return educationService.insertEducation(education);
	}

	// skills
	@Override
	public UserProfile createSkill(int profileId, List<Skill> skill) {
		UserProfile userProfile = getUserProfileById(profileId);
		List<Skill> skills;
		if (userProfile.getSkills() == null) {
			skills = new ArrayList<>();
			for (Skill skillitem : skill) {
				Skill s = skillService.getSkillById(skillitem.getId());
				skills.add(s);
			}

		} else {
			skills = userProfile.getSkills();
			List<Integer> ids = new ArrayList<>();
			for (Skill s : skills) {
				ids.add(s.getId());
			}
			for (Skill skillitem : skill) {
				if (!ids.contains(skillitem.getId())) {
					Skill s = skillService.getSkillById(skillitem.getId());
					skills.add(s);
				}
			}
		}

		userProfile.setSkills(skills);
		return updateUserProfile(userProfile);

	}

}
