package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Company;
import com.global.Entity.Industry;
import com.global.Repository.IndustryRepo;
import com.global.Services.IndustryCompanyService;
import com.global.Services.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryRepo industryRepo;

	@Autowired
	IndustryCompanyService industryCompanyService;

	@Override
	public List<Industry> getAllIndustries() {
		// TODO Auto-generated method stub
		try {
			return industryRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Industries " + e);
		}

	}

	@Override
	public Industry insertIndustry(Industry industry) {
		// TODO Auto-generated method stub
		try {
			return industryRepo.save(industry);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Industry " + e);
		}
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
			throw new RuntimeException("Industry not found for ID: " + industry.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update industry", e);
		}
	}

	@Override
	public boolean deleteIndustry(int id) {
		try {
			Industry industry = getIndustryById(id);
			for (Company company : new ArrayList<>(industry.getCompanies())) {
				industry.getCompanies().remove(company);
				industryCompanyService.deleteCompany(company.getId());
			}
			industryRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Industry For ID: " + id + "\n" + e);
			return false;
		}

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
}
