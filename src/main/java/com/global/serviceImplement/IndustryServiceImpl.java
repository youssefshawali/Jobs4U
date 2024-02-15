package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Company;
import com.global.Entity.Government;
import com.global.Entity.Industry;
import com.global.Repository.IndustryRepo;
import com.global.Services.CompanyService;
import com.global.Services.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryRepo industryRepo;

	@Override
	public List<Industry> getAllIndustries() {
		// TODO Auto-generated method stub
		return industryRepo.findAll();
	}

	@Override
	public Industry insertIndustry(Industry industry) {
		// TODO Auto-generated method stub
		return industryRepo.save(industry);
	}

	@Override
	public Industry updateIndustry(Industry industry) {
		// TODO Auto-generated method stub
		try {
			Industry current = industryRepo.findById(industry.getId()).orElseThrow();
			if (industry.getType() != null) {
				current.setType(industry.getType());
			}
			if (industry.getCompanies() != null) {
				current.setCompanies(industry.getCompanies());
			}
			return industryRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("industry not found for ID: " + industry.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update industry", e);
		}
	}

	@Override
	public void deleteIndustry(int id) {
		// TODO Auto-generated method stub
		industryRepo.deleteById(id);
	}

	@Override
	public Industry getIndustryById(int id) {
		// TODO Auto-generated method stub
		Optional<Industry> industry = industryRepo.findById(id);
		if (industry.isPresent()) {
			return industry.get();
		}
		throw new RuntimeException("Industry Not Fond");

	}

//	@Override
//	public Company createCompany(int industryId, Company company) {
//		// TODO Auto-generated method stub
//		Industry industry = getIndustryById(industryId);
//		company.setIndustry(industry);
//		return companyservice.insertCompany(company);
//	}
}