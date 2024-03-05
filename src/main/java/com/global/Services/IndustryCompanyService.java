package com.global.Services;

import java.util.List;


import com.global.Entity.Company;
import com.global.Entity.Industry;

import org.springframework.stereotype.Service;
@Service

public interface IndustryCompanyService {
	
	
void deleteCompany(int id);
	
	Company getCompanyById(int id);
	
}
