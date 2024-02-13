package com.global.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.UserProfile;
import com.global.Services.UserProfileService;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;
	
	@GetMapping("/")
	public List<UserProfile> getAllUserProfiles(){
		return userProfileService.getAllUserProfiles();
	}
	
	@GetMapping("/{id}")
	public UserProfile getUserProfile(@PathVariable int id) {
		return userProfileService.getUserProfileById(id);
	}
	
	@PostMapping("/")
	public UserProfile saveUserProfile (@RequestBody UserProfile userProfile) {
		return userProfileService.insertUserProfile(userProfile);
	}
	
	@PutMapping("/")
	public UserProfile updateUserProfile (@RequestBody UserProfile userProfile) {
		System.out.println("ID qqqqqqqqqqqqqqqqq "+userProfile.getId());
		return userProfileService.updateUserProfile(userProfile);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserProfile(@PathVariable int id) {
		userProfileService.deleteUserProfile(id);
	}
}
