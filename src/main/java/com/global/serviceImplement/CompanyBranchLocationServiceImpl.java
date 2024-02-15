package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Department;
import com.global.Entity.Government;
import com.global.Entity.CompanyBranchLocation;
import com.global.Repository.CompanyBranchLocationRepo;
import com.global.Services.CompanyBranchLocationService;

@Service
public class CompanyBranchLocationServiceImpl implements CompanyBranchLocationService {

	@Autowired
	private CompanyBranchLocationRepo companyBranchLocationRepo;

	@Override
	public List<CompanyBranchLocation> getAllCompanyBranchLocations() {
		// TODO Auto-generated method stub
		return companyBranchLocationRepo.findAll();
	}

	@Override
	public CompanyBranchLocation insertCompanyBranchLocation(CompanyBranchLocation CompanyBranchLocation) {
		// TODO Auto-generated method stub
		return companyBranchLocationRepo.save(CompanyBranchLocation);
	}

	@Override
	public CompanyBranchLocation updateCompanyBranchLocation(CompanyBranchLocation companyBranchLocation) {
		// TODO Auto-generated method stub
		try {
			CompanyBranchLocation current = companyBranchLocationRepo.findById(companyBranchLocation.getId())
					.orElseThrow();
			if (companyBranchLocation.getCompany() != null) {
				current.setCompany(companyBranchLocation.getCompany());
			}
			if (companyBranchLocation.getLocation() != null) {
				current.setLocation(companyBranchLocation.getLocation());
			}
			if (companyBranchLocation.getBranchName() != null) {
				current.setBranchName(companyBranchLocation.getBranchName());
			}
			return companyBranchLocationRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("company Branch Location not found for ID: " + companyBranchLocation.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update company Branch Location", e);
		}
	}

	@Override
	public void deleteCompanyBranchLocation(int id) {
		// TODO Auto-generated method stub
		companyBranchLocationRepo.deleteById(id);
	}

	@Override
	public CompanyBranchLocation getCompanyBranchLocationById(int id) {
		// TODO Auto-generated method stub
		Optional<CompanyBranchLocation> CompanyBranchLocation = companyBranchLocationRepo.findById(id);
		if (CompanyBranchLocation.isPresent()) {
			return CompanyBranchLocation.get();
		}
		throw new RuntimeException("Company Branch Location Not Fond");
	}

}
