package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Company;
import com.global.Entity.Job;
import com.global.Entity.User;
import com.global.Repository.CompanyRepo;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	JobService jobservice;
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public Company insertCompany(Company Company) {
		// TODO Auto-generated method stub
		return companyRepo.save(Company);
	}

	@Override
	public Company updateCompany(Company Company) {
		// TODO Auto-generated method stub
		Company current = companyRepo.findById(Company.getId()).orElseThrow();

		current.setName(Company.getName());
		current.setEmail(Company.getEmail());
		current.setWebSite(Company.getWebSite());		
		current.setPassword(Company.getPassword());		
		current.setAbout(Company.getAbout());
		current.setFoundedYear(Company.getFoundedYear());
		current.setMainLocation(Company.getMainLocation());
		current.setSpecialists(Company.getSpecialists());
		current.setSize(Company.getSize());
		current.setProfilePicture(Company.getProfilePicture());
		current.setCoverPicture(Company.getCoverPicture());
		current.setBranchLocations(Company.getBranchLocations());
		current.setIndustry(Company.getIndustry());
		
		return companyRepo.save(current);
	}

	@Override
	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		companyRepo.deleteById(id);
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		Optional<Company> Company = companyRepo.findById(id);
		if(Company.isPresent()) {
			return Company.get();
		}
		throw new RuntimeException("User Not Fond");
	}

	@Override
	public Job createjob(int companyId, Job job) {
    Company company = getCompanyById(companyId);
    job.setCompanyId(company);
	return jobservice.insertJob(job) ;
	}

}
