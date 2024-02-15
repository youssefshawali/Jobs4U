package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.Company;
import com.global.Entity.User;
import com.global.Repository.CareerLevelRepo;
import com.global.Repository.CompanyRepo;
import com.global.Repository.UserRepo;
import com.global.Services.CareerLevelService;
import com.global.Services.CompanyService;
import com.global.Services.LoginService;
import com.global.Services.SignupService;
import com.global.Services.UserService;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CompanyService companyService;
	@Autowired
	UserService userService;

	@Override
	public Boolean checkEmail(String email) {
		Company company = companyRepo.findByEmail(email);
		User user = userRepo.findByEmail(email);

		if (company != null || user != null) {
			return false;
		}
		return true;
	}

	@Override
	public Company companySignup(Company company) {
		if (checkEmail(company.getEmail())) {
			return companyService.insertCompany(company);
		}
		throw new Error("Email is already in use");
	}

	@Override
	public User userSignup(User user) {
		if (checkEmail(user.getEmail())) {
			return userService.insertUser(user);
		}
		throw new Error("Email is already in use");
	}
}
