package com.global.Services;

import java.util.List;

import com.global.Entity.CareerLevel;
import com.global.Entity.Company;
import com.global.Entity.User;

import org.springframework.stereotype.Service;
@Service

public interface LoginService {
	
	
	Company getCompanyByEmail(String email,String password);
	User getUserByEmail(String email,String password);
	public Object login(String email , String password);
}
