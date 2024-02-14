package com.global.Services;

import java.util.List;

import com.global.Entity.College;
import com.global.Entity.Company;
import com.global.Entity.Job;
import com.global.Entity.Location;


public interface CompanyService {
	
	Job createjob(int companyId, Job job);

	List<Company> getAllCompanies();
	
	Company insertCompany(Company Company);
	
	Company updateCompany (Company Company);
	
	void deleteCompany(int id);
	
	Company getCompanyById(int id);

	Company addCompanyLocation(int companyId,Location location);
}
