package com.global.Services;

import java.util.List;

import com.global.Entity.College;
import com.global.Entity.Company;
import com.global.Entity.Job;


public interface CompanyService {
	
	Job createjob(int companyId, Job job);

	List<Company> getAllCompanies(String name);
	
	Company insertCompany(Company Company);
	
	Company updateCompany (Company Company);
	
	void deleteCompany(int id);
	
	Company getCompanyById(int id);
}
