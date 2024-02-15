package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Entity.Experience;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Repository.EducationRepo;
import com.global.Repository.UserProfileRepo;
import com.global.Repository.UserRepo;
import com.global.Services.CollegeService;
import com.global.Services.EducationService;
import com.global.Services.ExperienceService;
import com.global.Services.SkillService;
import com.global.Services.UserProfileService;
import com.global.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserProfileService userProfileService;
	@Autowired
	SkillService skillService;
	@Autowired
	EducationService educationService;

	@Autowired

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Autowired
	CollegeService collegeService;
	@Autowired
	ExperienceService experienceService;

	public UserProfile createUserProfile(int userId, UserProfile userProfile) {
		User user = getUserById(userId);
		userProfile.setUser(user);
		College college = new College();
		List<Education> educations = userProfile.getEducation();

		if (educations != null) {
			for (Education education : educations) {
				// Set the UserProfile for each Education
				education.setUserProfile(userProfile);
				college = collegeService.getCollegeById(education.getCollege().getId());
				education.setCollege(college);
				// Optionally, you can save each Education here
				// educationRepo.save(education);
			}
			
		}

		List<Experience> experiences = new ArrayList<>();

		if (userProfile.getExperience() != null) {
			for (Experience experience : userProfile.getExperience()) {

				experienceService.insertExperience(experience);
				experiences.add(experience);
			}
			userProfile.setExperience(experiences);
		}
		
		List<Skill> savedSkills = new ArrayList<>();
		Skill skill = new Skill();
		if(userProfile.getSkills()!=null) {
			for(Skill s : userProfile.getSkills()) {
				skill = skillService.getSkillById(s.getId());
				savedSkills.add(skill);
			}
			userProfile.setSkills(savedSkills);
		}
		
//		List<Education> educations = new ArrayList<>();
//
//		if (userProfile.getEducation() != null) {
//			for (Education educ : userProfile.getEducation()) {
//
//				educationService.insertEducation(educ);
//				educations.add(educ);
//			}
//			userProfile.setExperience(experiences);
//		}

		// Save the UserProfile with its associated Education entries
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
		if (user.getFname() != null) {
			current.setFname(user.getFname());
		}
		if (user.getLname() != null) {
			current.setLname(user.getLname());
		}
		if (user.getPhoneNumber() != null) {
			current.setPhoneNumber(user.getPhoneNumber());
		}
		if (user.getEmail() != null) {
			current.setEmail(user.getEmail());
		}
		if (user.getPassword() != null) {
			current.setPassword(user.getPassword());
		}
		if (user.getAge() != 0) {
			current.setAge(user.getAge());
		}
		if (user.getProfilePicture() != null) {
			current.setProfilePicture(user.getProfilePicture());
		}
		if (user.getUserProfile() != null) {
			current.setUserProfile(user.getUserProfile());
		}
		if (user.getAppliedJobs() != null) {
			current.setAppliedJobs(user.getAppliedJobs());
		}
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
