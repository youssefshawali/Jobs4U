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

@RestController
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	SignupService signupService;

	@PostMapping("/companySignup")
	public Company companySignup(@RequestBody Company company) {
		return signupService.companySignup(company);
	}

	@PostMapping("/userSignup")
	public User companySignup(@RequestBody User user) {
		return signupService.userSignup(user);
	}
}
