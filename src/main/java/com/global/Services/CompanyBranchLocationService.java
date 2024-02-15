package com.global.Services;

import java.util.List;

import com.global.Entity.CompanyBranchLocation;


public interface CompanyBranchLocationService {

	List<CompanyBranchLocation> getAllCompanyBranchLocations();
	
	CompanyBranchLocation insertCompanyBranchLocation(CompanyBranchLocation CompanyBranchLocation);
	
	CompanyBranchLocation updateCompanyBranchLocation (CompanyBranchLocation CompanyBranchLocation);
	
	void deleteCompanyBranchLocation(int id);
	
	CompanyBranchLocation getCompanyBranchLocationById(int id);
}
