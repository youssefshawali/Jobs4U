package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.City;
import com.global.Entity.Company;
import com.global.Entity.Department;
import com.global.Entity.Industry;
import com.global.Entity.Job;
import com.global.Entity.Location;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Repository.CompanyRepo;
import com.global.Services.CareerLevelService;
import com.global.Services.CityService;
import com.global.Services.CompanyService;
import com.global.Services.DepartmentService;
import com.global.Services.IndustryCompanyService;
import com.global.Services.IndustryService;
import com.global.Services.JobService;
import com.global.Services.LocationService;
import com.global.Services.QualificationService;
import com.global.Services.SkillService;

@Service
public class IndustryCompanyServiceImpl implements IndustryCompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private JobService jobService;

	@Autowired
	private LocationService locationService;

	

		


	@Override
	public boolean deleteCompany(int id) {
		// TODO Auto-generated method stub

		try {
			Company company = getCompanyById(id);
			if (company != null) {
				if (company.getIndustry() != null) {
//				Industry industry = industryService.getIndustryById(company.getIndustry().getId());
					company.getIndustry().getCompanies().remove(company);
					company.setIndustry(null);
				}
				for (Job job : new ArrayList<>(company.getJobs())) {
					company.getJobs().remove(job); // Remove from company's job list
					jobService.deleteJob(job.getId()); // Delete the job
				}
				for (Location loc : new ArrayList<>(company.getLocations())) {
					loc.setCompany(null);
					locationService.updateLocation(loc);
					locationService.deleteLocation(loc.getId());
					company.getLocations().remove(loc);

				}
				companyRepo.save(company);
				companyRepo.deleteById(id);
				return true;

			}
			System.err.println("No Company Can Be Found For ID: " + id);
			return false;
		} catch (Exception e) {
			System.err.println("Cant Delete Company For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		Optional<Company> company = companyRepo.findById(id);
		if (company.isPresent()) {
			return company.get();
		}
		throw new RuntimeException("Company Not Fond");
	}

	
}
