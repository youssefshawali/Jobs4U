package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.Company;
import com.global.Entity.Department;
import com.global.Entity.Education;
import com.global.Entity.Industry;
import com.global.Entity.Job;
import com.global.Entity.Location;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Entity.User;
import com.global.Repository.CompanyRepo;
import com.global.Services.CareerLevelService;
import com.global.Services.CompanyService;
import com.global.Services.DepartmentService;
import com.global.Services.IndustryService;
import com.global.Services.JobService;
import com.global.Services.LocationService;
import com.global.Services.QualificationService;
import com.global.Services.SkillService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private JobService jobservice;
	@Autowired
	private CareerLevelService careerLevelService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private QualificationService qualificationservice;
	@Autowired
	private LocationService locationService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private DepartmentService departmentService;


	@Override
	public List<Company> getAllCompanies(String name) {
		// TODO Auto-generated method stub
		if (name != null) {
			return companyRepo.findAll(name);
		} else {
			return companyRepo.findAll();
		}
	}

	@Override
	public Company insertCompany(Company company) {
		// TODO Auto-generated method stub
		if (company.getIndustry() != null) {
			Industry industry = industryService.getIndustryById(company.getIndustry().getId());
			company.setIndustry(industry);
		}
		setCompanyLocations(company);
		return companyRepo.save(company);

	}

	@Override
	public Company updateCompany(Company Company) {
		// TODO Auto-generated method stub
		Company current = companyRepo.findById(Company.getId()).orElseThrow();
		if (Company.getName() != null) {
			current.setName(Company.getName());
		}
		if (Company.getEmail() != null) {
			current.setEmail(Company.getEmail());
		}
		if (Company.getWebSite() != null) {
			current.setWebSite(Company.getWebSite());
		}
		if (Company.getPassword() != null) {
			current.setPassword(Company.getPassword());
		}
		if (Company.getAbout() != null) {
			current.setAbout(Company.getAbout());
		}
		if (Company.getFoundedYear() != 0) {
			current.setFoundedYear(Company.getFoundedYear());
		}
		if (Company.getLocations() != null) {
			current.setLocations(Company.getLocations());
		}
		if (Company.getSpecialists() != null) {
			current.setSpecialists(Company.getSpecialists());
		}
		if (Company.getSize() != 0) {
			current.setSize(Company.getSize());
		}
		if (Company.getProfilePicture() != null) {
			current.setProfilePicture(Company.getProfilePicture());
		}
		if (Company.getCoverPicture() != null) {
			current.setCoverPicture(Company.getCoverPicture());
		}

		if (Company.getIndustry() != null) {
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
		Optional<Company> company = companyRepo.findById(id);
		if (company.isPresent()) {
			return company.get();
		}
		throw new RuntimeException("User Not Fond");
	}

	@Override
	public Job createjob(int companyId, Job job) {
		Company company = getCompanyById(companyId);
		job.setCompanyId(company);
		addJobCareerLevels(job);
		addJobSkills(job);
		addJobQualification(job);
		addJobLocation(job);
		addJobDepartment(job);
		return jobservice.insertJob(job);
	}

	@Override
	public Company addCompanyLocation(int companyId, Location location) {
		// TODO Auto-generated method stub
		Company company = getCompanyById(companyId);
		List<Location> locations = new ArrayList<>();
		if (location != null) {
			location.setCompany(company);
			locationService.insertLocation(location);
			locations = company.getLocations();
			locations.add(location);
			company.setLocations(locations);
		}
		return company;

	}

	public void setCompanyLocations(Company company) {

		if (company.getLocations().size() != 0) {
			List<Location> locations = new ArrayList<>();
			for (Location location : company.getLocations()) {
				location.setCompany(company);
				locations.add(location);
//				locationService.insertLocation(location);
			}
			company.setLocations(locations);
		}
	}

	public void addJobCareerLevels(Job job) {
		List<CareerLevel> savedCareerLevels = new ArrayList<>();
		CareerLevel cl = new CareerLevel();
		if (job.getCareerLevels() != null) {
			for (CareerLevel careerLevel : job.getCareerLevels()) {
				cl = careerLevelService.getCareerLevelById(careerLevel.getId());
				savedCareerLevels.add(cl);
			}
			job.setCareerLevels(savedCareerLevels);

		}
	}

	public void addJobSkills(Job job) {
		List<Skill> savedSkillList = new ArrayList<>();
		Skill skill = new Skill();
		if (job.getSkills() != null) {
			for (Skill s : job.getSkills()) {
				skill = skillService.getSkillById(s.getId());
				savedSkillList.add(skill);
			}
			job.setSkills(savedSkillList);
		}
	}

	public void addJobQualification(Job job) {
		List<Qualification> savedQualificationList = new ArrayList<>();
		Qualification qualification = new Qualification();
		if (job.getQualification() != null) {
			for (Qualification s : job.getQualification()) {
				qualification = qualificationservice.getQualificationById(s.getId());
				savedQualificationList.add(qualification);
			}
			job.setQualification(savedQualificationList);
		}
	}

	public void addJobLocation(Job job) {

		if (job.getLocation() != null) {
			Location location = locationService.getLocationById(job.getLocation().getId());
			job.setLocation(location);
		}
	}

	public void addJobDepartment(Job job) {

		if (job.getDepartment() != null) {
			Department department = departmentService.getDepartmentById(job.getDepartment().getId());
			job.setDepartment(department);
		}
	}
}
