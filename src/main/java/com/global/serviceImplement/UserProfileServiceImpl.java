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
		try {
			return userProfileRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Profiles " + e);
		}

	}

	@Override
	public boolean deleteUserProfile(int id) {
		// TODO Auto-generated method stub
		try {
			UserProfile userProfile = getUserProfileById(id);
			if (userProfile != null) {
				if (!userProfile.getExperience().isEmpty()) {
					for (Experience exp : new ArrayList<>(userProfile.getExperience())) {
						exp.setUserProfile(null); // Disassociate education from user profile
						userProfile.getExperience().remove(exp);
						experienceService.updateExperience(exp);
						experienceService.deleteExperience(exp.getId()); // Delete the education
					}

				}
				if (userProfile.getEducation().size() != 0) {
					for (Education edu : new ArrayList<>(userProfile.getEducation())) {
						edu.setUserProfile(null); // Disassociate education from user profile
						userProfile.getEducation().remove(edu);
						educationService.updateEducation(edu);
						educationService.deleteEducation(edu.getId()); // Delete the education
					}
				}
				if (userProfile.getSkills().size() != 0) {
					for (Skill skill : new ArrayList<>(userProfile.getSkills())) {
						userProfile.getSkills().remove(skill);
//				educationService.deleteEducation(edu.getId());
					}
				}
				updateUserProfile(userProfile);
				userProfileRepo.deleteById(id);
				return true;
			}
			System.err.println("No Profile Can Be Found For ID: " + id);
			return false;
		} catch (Exception e) {
			System.err.println("Cant Delete Profile For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public UserProfile insertUserProfile(UserProfile userProfile) {
		// TODO Auto-generated method stub
		try {
			return userProfileRepo.save(userProfile);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Profile " + e);
		}

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
			if (userProfile.getLanguages() != null) {
				current.setLanguages(userProfile.getLanguages());
			}
			if (userProfile.getSkills() != null) {
				current.setSkills(userProfile.getSkills());
			}
			if (userProfile.getCvFile() != null) {
				current.setCvFile(userProfile.getCvFile());
			}
			
			
			
//		current.setUser(userProfile.getUser());

			return userProfileRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Profile not found for ID: " + userProfile.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update Profile", e);
		}
	}

	@Override
	public UserProfile getUserProfileById(int id) {
		// TODO Auto-generated method stub
		Optional<UserProfile> userProfile = userProfileRepo.findById(id);
		if (userProfile.isPresent()) {
			return userProfile.get();
		}
		throw new RuntimeException("Profile Not Fond");

	}

	// Experience
	@Override
	public Experience createExperience(int profileId, Experience experience) {
		try {
			UserProfile userProfile = getUserProfileById(profileId);
			experience.setUserProfile(userProfile);
			return experienceService.insertExperience(experience);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding New Experience For Profile ID: " + profileId + "\n" + e);
		}
	}

	// Education
	@Override
	public Education createEducation(int profileId, Education education) {
		try {
			UserProfile userProfile = getUserProfileById(profileId);
			education.setUserProfile(userProfile);
			return educationService.insertEducation(education);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding New Education For Profile ID: " + profileId + "\n" + e);
		}
	}

	// skills
	@Override
	public UserProfile createSkill(int profileId, List<Skill> skill) {
		try {
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
		} catch (Exception e) {
			throw new RuntimeException("Error Adding New Skills For Profile ID: " + profileId + "\n" + e);

		}

	}

}
