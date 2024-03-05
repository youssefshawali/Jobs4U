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

//	@PostMapping("/")
//	public Object login(@RequestBody Login login) {
//		return loginService.login(login.getEmail(),login.getPassword());
//	}
	
	
	@PostMapping("/")
	public ResponseEntity<Response<Object>> login(@RequestBody Login login) {
	    Object result = loginService.login(login.getEmail(), login.getPassword());
	    Response<Object> response = new Response<>();

	    if (result != null) {
	        // Login successful
	        response.setStatus(HttpStatus.OK.value());
	        response.setMessage("Success");
	        response.setData(result);
	    } else {
	        // Login failed
	        response.setStatus(HttpStatus.UNAUTHORIZED.value());
	        response.setMessage("Login failed");
	        response.setData(null);
	    }

	    return ResponseEntity.ok(response);
	}
}
