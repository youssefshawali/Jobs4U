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
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private JobService jobService;
	@Autowired
	private CareerLevelService careerLevelService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private QualificationService qualificationService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	CityService cityService;

	@Override
	public Company insertCompany(Company company) {
		// TODO Auto-generated method stub
		try {
			if (company.getIndustry() != null) {
				Industry industry = industryService.getIndustryById(company.getIndustry().getId());
				company.setIndustry(industry);
			}
			setCompanyLocations(company);
			return companyRepo.save(company);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Company " + e);
		}

	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		try {
			Company current = companyRepo.findById(company.getId()).orElseThrow();
			if (company.getName() != null) {
				current.setName(company.getName());
			}
			if (company.getEmail() != null) {
				current.setEmail(company.getEmail());
			}
			if (company.getWebSite() != null) {
				current.setWebSite(company.getWebSite());
			}
			if (company.getPassword() != null) {
				current.setPassword(company.getPassword());
			}
			if (company.getAbout() != null) {
				current.setAbout(company.getAbout());
			}
			if (company.getFoundedYear() != 0) {
				current.setFoundedYear(company.getFoundedYear());
			}
			if (company.getLocations() != null) {
				current.setLocations(company.getLocations());
			}
			if (company.getSpecialists() != null) {
				current.setSpecialists(company.getSpecialists());
			}
			if (company.getSize() != 0) {
				current.setSize(company.getSize());
			}
			if (company.getProfilePicture() != null) {
				current.setProfilePicture(company.getProfilePicture());
			}
			if (company.getCoverPicture() != null) {
				current.setCoverPicture(company.getCoverPicture());
			}

			if (company.getIndustry() != null) {
				current.setIndustry(company.getIndustry());
			}

			return companyRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Company not found for ID: " + company.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update Company", e);
		}
	}

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

	@Override
	public Job createJob(int companyId, Job job) {
		try {
			Company company = getCompanyById(companyId);
			company.getJobs().add(job);
			updateCompany(company);
			job.setCompany(company);
			addJobCareerLevels(job);
			addJobSkills(job);
			addJobQualification(job);
			addJobLocation(job);
			addJobDepartment(job);
			return jobService.insertJob(job);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job " + e);
		}

	}

	@Override
	public Company addCompanyLocation(int companyId, Location location) {
		// TODO Auto-generated method stub
		try {
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
		} catch (Exception e) {
			throw new RuntimeException("Error Adding New Company Location For ID: " + companyId + "\n" + e);
		}
	}

	public void setCompanyLocations(Company company) {
		try {
			if (company.getLocations().size() != 0) {
				List<Location> locations = new ArrayList<>();
				City city = new City();
				for (Location location : company.getLocations()) {
					location.setCompany(company);
					city = cityService.getCityById(location.getCity().getId());
					location.setCity(city);
					locations.add(location);
//				locationService.insertLocation(location);
				}
				company.setLocations(locations);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error Setting Company Location " + e);
		}
	}

	public void addJobCareerLevels(Job job) {
		try {
			List<CareerLevel> savedCareerLevels = new ArrayList<>();
			CareerLevel cl = new CareerLevel();
			if (job.getCareerLevels() != null) {
				for (CareerLevel careerLevel : job.getCareerLevels()) {
					cl = careerLevelService.getCareerLevelById(careerLevel.getId());
					savedCareerLevels.add(cl);
				}
				job.setCareerLevels(savedCareerLevels);

			}
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job Career Levels " + e);
		}
	}

	public void addJobSkills(Job job) {
		try {
			List<Skill> savedSkillList = new ArrayList<>();
			Skill skill = new Skill();
			if (job.getSkills() != null) {
				for (Skill s : job.getSkills()) {
					skill = skillService.getSkillById(s.getId());
					savedSkillList.add(skill);
				}
				job.setSkills(savedSkillList);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job Skills " + e);
		}
	}

	public void addJobQualification(Job job) {
		try {
			List<Qualification> savedQualificationList = new ArrayList<>();
			Qualification qualification = new Qualification();
			if (job.getQualification() != null) {
				for (Qualification s : job.getQualification()) {
					qualification = qualificationService.getQualificationById(s.getId());
					savedQualificationList.add(qualification);
				}
				job.setQualification(savedQualificationList);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job Qualifications " + e);
		}
	}

	public void addJobLocation(Job job) {
		try {
			if (job.getLocation() != null) {
				Location location = locationService.getLocationById(job.getLocation().getId());
				job.setLocation(location);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job Location " + e);
		}
	}

	public void addJobDepartment(Job job) {
		try {
			if (job.getDepartment() != null) {
				Department department = departmentService.getDepartmentById(job.getDepartment().getId());
				job.setDepartment(department);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Job Department " + e);
		}
	}

	@Override
	public List<Company> getAllCompanies() {
		try {
			return companyRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Companies " + e);
		}
	}

	@Override
	public List<Location> getAllCompanyLocations(int companyId) {
		try {
			return locationService.getLocationByCompanyId(companyId);
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Locations For This Company ID: " + companyId + " \n" + e);
		}
	}
}
