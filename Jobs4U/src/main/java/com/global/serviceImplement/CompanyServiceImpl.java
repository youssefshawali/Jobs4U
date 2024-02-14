package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.Company;
import com.global.Entity.Education;
import com.global.Entity.Job;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Entity.User;
import com.global.Repository.CompanyRepo;
import com.global.Services.CareerLevelService;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
import com.global.Services.QualificationService;
import com.global.Services.SkillService;

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
		if(Company.getName()!= null) {
		current.setName(Company.getName());
		}
		if(Company.getEmail()!= null) {
		current.setEmail(Company.getEmail());
		}
		if(Company.getWebSite()!= null) {
		current.setWebSite(Company.getWebSite());
		}
		if(Company.getPassword()!= null) {
		current.setPassword(Company.getPassword());
		}
		if(Company.getAbout()!= null) {
		current.setAbout(Company.getAbout());
		}
		if(Company.getFoundedYear()!= 0) {
		current.setFoundedYear(Company.getFoundedYear());
		}
		if(Company.getMainLocation()!= null) {
		current.setMainLocation(Company.getMainLocation());
		}
		if(Company.getSpecialists()!= null) {
		current.setSpecialists(Company.getSpecialists());
		}
		if(Company.getSize()!= 0) {
		current.setSize(Company.getSize());
		}
		if(Company.getProfilePicture()!= null) {
		current.setProfilePicture(Company.getProfilePicture());
		}
		if(Company.getCoverPicture()!= null) {
		current.setCoverPicture(Company.getCoverPicture());
		}
		if(Company.getBranchLocations()!= null) {
		current.setBranchLocations(Company.getBranchLocations());
		}
		if(Company.getIndustry()!= null) {
		current.setIndustry(Company.getIndustry());
		}
		
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
		if (Company.isPresent()) {
			return Company.get();
		}
		throw new RuntimeException("User Not Fond");
	}

	@Autowired
	CareerLevelService careerLevelService;
	@Autowired
	SkillService skillService;
	@Autowired
	QualificationService qualificationservice;

	@Override
	public Job createjob(int companyId, Job job) {
		Company company = getCompanyById(companyId);
		job.setCompanyId(company);
		List<CareerLevel> savedCareerLevels = new ArrayList<>();
		CareerLevel cl = new CareerLevel();
		if (job.getCareerLevels() != null) {
			for (CareerLevel careerLevel : job.getCareerLevels()) {
				cl = careerLevelService.getCareerLevelById(careerLevel.getId());
				savedCareerLevels.add(cl);
			}
			job.setCareerLevels(savedCareerLevels);

		}
		List<Skill> savedSkillList = new ArrayList<>();
		Skill skill = new Skill();
		if(job.getSkills()!=null) {
			for(Skill s : job.getSkills()) {
				skill = skillService.getSkillById(s.getId());
				savedSkillList.add(skill);
			}
			job.setSkills(savedSkillList);
		}
		List<Qualification> savedQualificationList = new ArrayList<>();
		Qualification qualification = new Qualification();
		if(job.getQualification()!=null) {
			for(Qualification s : job.getQualification()) {
				qualification = qualificationservice.getQualificationById(s.getId());
				savedQualificationList.add(qualification);
			}
			job.setQualification(savedQualificationList);
		}
		
		
		return jobservice.insertJob(job);
	}

}
