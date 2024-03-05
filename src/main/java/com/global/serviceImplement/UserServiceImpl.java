package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Entity.Experience;
import com.global.Entity.Job;
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
import com.global.Services.JobService;
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
	CollegeService collegeService;
	@Autowired
	ExperienceService experienceService;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		try {
			return userRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Users " + e);
		}

	}

	public UserProfile createUserProfile(int userId, UserProfile userProfile) {
		try {
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
				}

			}

			List<Experience> experiences = new ArrayList<>();

			if (userProfile.getExperience().size() != 0) {
				System.out.println("Add Expoo");
				for (Experience experience : userProfile.getExperience()) {
					experience.setUserProfile(userProfile);
//				experienceService.insertExperience(experience);
					experiences.add(experience);
				}
				userProfile.setExperience(experiences);
			}

			List<Skill> savedSkills = new ArrayList<>();
			Skill skill = new Skill();
			if (userProfile.getSkills() != null) {
				for (Skill s : userProfile.getSkills()) {
					skill = skillService.getSkillById(s.getId());
					savedSkills.add(skill);
				}
				userProfile.setSkills(savedSkills);
			}

			return userProfileService.insertUserProfile(userProfile);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding User Profile For User ID: " + userId + "\n" + e);
		}
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			User user = getUserById(id);

			if (user != null) {
				UserProfile userProfile = user.getUserProfile();
				if (userProfile != null) {
					userProfile.setUser(null);
					user.setUserProfile(null);
					userProfileService.deleteUserProfile(userProfile.getId());
				}

				if (user.getAppliedJobs().size() != 0) {
					for (Job job : new ArrayList<>(user.getAppliedJobs())) {
						job.setApplicantsCount(job.getApplicantsCount() - 1);
						job.getApplicants().remove(user);
						user.getAppliedJobs().remove(job);
					}
				}
				userRepo.deleteById(id);
				return true;
			}
			System.err.println("No User Can Be Found For ID: " + id);
			return false;
		} catch (Exception e) {
			System.err.println("Cant Delete User For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		try {
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
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("User not found for ID: " + user.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update user", e);
		}
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

	@Autowired
	JobService jobService;

	@Override
	public String applyForJob(int userId, int jobId) {
		try {
			User user = getUserById(userId);
			Job job = jobService.getJobById(jobId);
			List<User> userList;
			if (job.getApplicants().size() == 0) {
				userList = new ArrayList<>();
				userList.add(user);
				job.setApplicants(userList);

			} else {

				userList = job.getApplicants();
				userList.add(user);
				job.setApplicants(userList);
			}
			int old = job.getApplicants().size();
			job = jobService.updateJob(job);
			int newObj = job.getApplicants().size();
			if (old != newObj) {
				job.setApplicantsCount(job.getApplicantsCount() + 1);
			}
			return "Application Successfully";
		} catch (Exception e) {
			System.err.println("Error Applying User ID: " + userId + " For Job ID: " + jobId + "\n" + e);
			return null;

		}
	}

}
