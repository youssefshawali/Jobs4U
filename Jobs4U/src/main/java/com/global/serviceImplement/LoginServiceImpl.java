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
import com.global.Services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public Company getCompanyByEmail(String email, String password) {
		Company company = companyRepo.findByEmail(email);

		if (company != null) {
			if (verifyPassword(password,company.getPassword())){
				return company;
			} else {
				throw new Error("Company password isnt correct");
			}
		}
		return null;
	}

	@Override
	public User getUserByEmail(String email, String password) {
		User user = userRepo.findByEmail(email);

		if (user != null) {
//			System.out.println("Saved Password " + user.getPassword() + " Login Password " + password);
			if (verifyPassword(password,user.getPassword())) {
				return user;
			} else {
				throw new Error("User password isnt correct");
			}
		}
		return user;
	}

	public Object login(String email, String password) {
		Company company = getCompanyByEmail(email, password);
		User user = getUserByEmail(email, password);
		if (company != null)
			return company;
		else if (user != null)
			return user;
		else
			return null;
	}
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public boolean verifyPassword(String savedPassword, String loginPassword) {
	    return encoder.matches(savedPassword, loginPassword);
	}
}
