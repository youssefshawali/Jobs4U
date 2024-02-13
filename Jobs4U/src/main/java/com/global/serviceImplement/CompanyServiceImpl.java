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
