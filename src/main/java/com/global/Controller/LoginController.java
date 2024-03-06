package com.global.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Login;
import com.global.Services.LoginService;

import ApiResponse.Response;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/")
	public Response<Object> login(@RequestBody Login login) {
		Object result = loginService.login(login.getEmail(), login.getPassword());

		if (result != null) {
			return new Response<>(200, "Login successful", result);
		} else {
			return new Response<>(404, "Login failed", null);
		}
	}
}
