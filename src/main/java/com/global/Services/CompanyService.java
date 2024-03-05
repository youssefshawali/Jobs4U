package com.global.Services;

import java.util.List;
import com.global.Entity.Company;
import com.global.Entity.Job;
import com.global.Entity.Location;

import org.springframework.stereotype.Service;
@Service

public interface CompanyService {
	
	Job createJob(int companyId, Job job);

	List<Company> getAllCompanies();
	
	Company insertCompany(Company company);
	
	Company updateCompany (Company company);
	
	

	Company addCompanyLocation(int companyId,Location location);

	List<Location> getAllCompanyLocations(int copmpanyId);

	void deleteCompany(int id);

	Company getCompanyById(int id);
}
