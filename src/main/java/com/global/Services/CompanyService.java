package com.global.Services;

import java.util.List;
import com.global.Entity.Company;
import com.global.Entity.Job;
import com.global.Entity.Location;


public interface CompanyService {
	
	Job createJob(int companyId, Job job);

	List<Company> getAllCompanies(String name);
	
	Company insertCompany(Company company);
	
	Company updateCompany (Company company);
	
	void deleteCompany(int id);
	
	Company getCompanyById(int id);

	Company addCompanyLocation(int companyId,Location location);
}
