package com.global.Services;

import java.util.List;

import com.global.Entity.Company;
import com.global.Entity.User;
import org.springframework.stereotype.Service;
@Service
public interface SignupService {

	public Boolean checkEmail(String email);

	public Company companySignup(Company company);

	public User userSignup(User user);
}
