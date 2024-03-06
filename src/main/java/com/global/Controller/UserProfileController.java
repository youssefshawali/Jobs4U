package com.global.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Entity.Experience;
import com.global.Entity.Skill;
import com.global.Entity.UserProfile;
import com.global.Services.UserProfileService;

import ApiResponse.Response;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	@GetMapping("/")
	public Response<List<UserProfile>> getAllUsers() {
		List<UserProfile> profiles = userProfileService.getAllUserProfiles();
		if (profiles.size() != 0) {
			return new Response<>(200, "Success", profiles);
		} else {
			return new Response<>(404, "No profiles found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<UserProfile> getUserProfile(@PathVariable int id) {
		UserProfile profile = userProfileService.getUserProfileById(id);
		if (profile != null) {
			return new Response<>(200, "Success", profile);
		} else {
			return new Response<>(404, "No profiles found", null);
		}

	}

	@PostMapping("/")
	public Response<UserProfile> saveUserProfile(@RequestBody UserProfile userProfile) {
		UserProfile profile = userProfileService.insertUserProfile(userProfile);
		if (profile != null) {
			return new Response<>(200, "User profile saved successfully", profile);
		} else {
			return new Response<>(404, "Failed to save user profile", null);
		}
	}

	@PutMapping("/")
	public Response<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile) {

		UserProfile profile = userProfileService.updateUserProfile(userProfile);
		if (profile != null) {
			return new Response<>(200, "User profile updated successfully", profile);
		} else {
			return new Response<>(404, "Failed to update user profile", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteUserProfile(@PathVariable int id) {
		boolean deleted = userProfileService.deleteUserProfile(id);
		if (deleted) {
			return new Response<>(200, "User profile deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete user profile", null);
		}
	}

	@PostMapping("/{profileId}/experience")
	public Response<Experience> createExperience(@PathVariable int profileId, @RequestBody Experience experience) {
		Experience createexperience = userProfileService.createExperience(profileId, experience);
		if (createexperience != null) {
			return new Response<>(200, "Experience added successfully", createexperience);
		} else {
			return new Response<>(404, "Failed to create experience", null);
		}

	}

	@PostMapping("/{profileId}/education")
	public Response<Education> createEducation(@PathVariable int profileId, @RequestBody Education education) {

		Education createeducation = userProfileService.createEducation(profileId, education);
		if (createeducation != null) {
			return new Response<>(200, "Education added successfully", createeducation);
		} else {
			return new Response<>(404, "Failed to create education", null);
		}
	}

	@PostMapping("/{profileId}/skill")
	public Response<UserProfile> createSkill(@PathVariable int profileId, @RequestBody List<Skill> skill) {
		UserProfile profile = userProfileService.createSkill(profileId, skill);
		if (profile != null) {
			return new Response<>(200, "Skill added successfully", profile);
		} else {
			return new Response<>(404, "Failed to create skill", null);
		}
	}

}
