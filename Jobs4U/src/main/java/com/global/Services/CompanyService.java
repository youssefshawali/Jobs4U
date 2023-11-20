package com.global.Services;

import java.util.List;

import com.global.Entity.Company;


public interface CompanyService {

	List<Company> getAllCompanys();
	
	Company insertCompany(Company Company);
	
	Company updateCompany (Company Company);
	
	void deleteCompany(int id);
	
	Company findCompanyById(int id);
}
