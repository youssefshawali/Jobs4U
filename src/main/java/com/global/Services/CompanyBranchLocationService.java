package com.global.Services;

import java.util.List;

import com.global.Entity.CompanyBranchLocation;


public interface CompanyBranchLocationService {

	List<CompanyBranchLocation> getAllCompanyBranchLocations();
	
	CompanyBranchLocation insertCompanyBranchLocation(CompanyBranchLocation companyBranchLocation);
	
	CompanyBranchLocation updateCompanyBranchLocation (CompanyBranchLocation companyBranchLocation);
	
	void deleteCompanyBranchLocation(int id);
	
	CompanyBranchLocation getCompanyBranchLocationById(int id);
}
