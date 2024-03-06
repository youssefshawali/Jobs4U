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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Education;
import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Services.UserService;

import ApiResponse.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public Response<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		if (users.size() != 0) {
			return new Response<>(200, "Success", users);
		} else {
			return new Response<>(404, "No users found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<User>  getUser(@PathVariable int id) {
		User user = userService.getUserById(id);
		if (user != null) {
			return new Response<>(200, "Success", user);
		} else {
			return new Response<>(404, "No user found", null);
		}
	}
	

	@PostMapping("/")
	public  Response<User> saveUser(@RequestBody User user) {
		User saveuser= userService.insertUser(user);
		if (saveuser != null) {
			return new Response<>(200, "User  saved successfully", saveuser);
		} else {
			return new Response<>(404, "Failed to save user ", null);
		}
	}

	@PostMapping("/{userId}/profile")
	public Response<UserProfile> createUserProfile(@PathVariable int userId, @RequestBody UserProfile userProfile) {
		UserProfile profile = userService.createUserProfile(userId, userProfile);
		 if (profile != null) {
		        return new Response<>(200, "User Profile added successfully", profile);
		    } else {
		        return new Response<>(404, "Failed to create User Profile", null);
		    }
	}
	

	@PutMapping("/")
	public Response<User> updateUser(@RequestBody User user) {
		User updateuser = userService.updateUser(user);
		 if (updateuser != null) {
		        return new Response<>(200, "User info updated successfully", updateuser);
		    } else {
		        return new Response<>(404, "Failed to update user info", null);
		    }
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteUser(@PathVariable int id) {		
	    boolean deleted = userService.deleteUser(id);
	    if (deleted) {
	        return new Response<>(200, "User  deleted successfully", null);
	    } else {
	        return new Response<>(404, "Failed to delete user ", null);
	    }
		
	}

	@PostMapping("/apply")
	public Response<String> applyForJob(@RequestParam int userId, @RequestParam int jobId) {
		String applyjob = userService.applyForJob(userId, jobId);
		 if (applyjob != null) {
		        return new Response<>(200, "Job applied successfully", applyjob);
		    } else {
		        return new Response<>(404, "Failed to apply job", null);
		    }
		
	}
}
