package com.global.Services;

import java.util.List;

import com.global.Entity.CompanyBranchLocation;

import org.springframework.stereotype.Service;
@Service

public interface CompanyBranchLocationService {

	List<CompanyBranchLocation> getAllCompanyBranchLocations();
	
	CompanyBranchLocation insertCompanyBranchLocation(CompanyBranchLocation companyBranchLocation);
	
	CompanyBranchLocation updateCompanyBranchLocation (CompanyBranchLocation companyBranchLocation);
	
	void deleteCompanyBranchLocation(int id);
	
	CompanyBranchLocation getCompanyBranchLocationById(int id);
}
