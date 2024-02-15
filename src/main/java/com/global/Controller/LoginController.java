package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Login;
import com.global.Services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/")
	public Object login(@RequestBody Login login) {
		return loginService.login(login.getEmail(),login.getPassword());
	}
}
