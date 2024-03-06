package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Company;
import com.global.Entity.Login;
import com.global.Entity.User;
import com.global.Services.LoginService;
import com.global.Services.SignupService;

import ApiResponse.Response;

@RestController
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	SignupService signupService;

	@PostMapping("/companySignup")
	public Response<Company> companySignup(@RequestBody Company company) {
		Company companysign = signupService.companySignup(company);
		if (companysign != null) {
			return new Response<>(200, "Company signed up successfully", companysign);
		} else {
			return new Response<>(404, "Failed to sign up company", null);
		}
	}

	@PostMapping("/userSignup")
	public Response<User> userSignup(@RequestBody User user) {
		User usersign = signupService.userSignup(user);
		if (usersign != null) {
			return new Response<>(200, "User signed up successfully", usersign);
		} else {
			return new Response<>(404, "Failed to sign up user", null);
		}
	}
}
