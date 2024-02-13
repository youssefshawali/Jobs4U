package com.global.Services;

import java.util.List;

import com.global.Entity.Company;
import com.global.Entity.CompanyBranchLocation;


public interface CompanyService {

	List<Company> getAllCompanies();
	
	Company insertCompany(Company Company);
	
	
	Company updateCompany (Company Company);
	
	void deleteCompany(int id);
	
	Company getCompanyById(int id);


	CompanyBranchLocation createBranchLocation(int companyId, CompanyBranchLocation companyBranchLocation);
}
