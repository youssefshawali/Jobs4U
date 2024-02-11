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

import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/")
	public User saveUser (@RequestBody User user) {
		return userService.insertUser(user);
	}
	 @PostMapping("/{userId}/profile")
	    public UserProfile createUserProfile(@PathVariable int userId, @RequestBody UserProfile userProfile) {
	        return userService.createUserProfile(userId, userProfile);
	    }
	
	@PutMapping("/")
	public User updateUser (@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
