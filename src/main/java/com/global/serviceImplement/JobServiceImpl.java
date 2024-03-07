package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.CareerLevel;
import com.global.Entity.Department;
import com.global.Entity.Job;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Entity.User;
import com.global.Services.CareerLevelService;
import com.global.Services.DepartmentService;
import com.global.Services.JobService;
import com.global.Services.LocationService;
import com.global.Services.QualificationService;
import com.global.Services.SkillService;
import com.global.Repository.JobRepo;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepo jobRepo;
	@Autowired
	LocationService locationService;
	@Autowired
	QualificationService qualificationService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	CareerLevelService careerLevelService;
	@Autowired
	SkillService skillService;

	@Override
	public Job insertJob(Job job) {
		// TODO Auto-generated method stub
		try {
			return jobRepo.save(job);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding City " + e);
		}

	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		Job current = jobRepo.findById(job.getId()).orElseThrow();
		try {

			    if (job.getJobTitle() != null) {
			        current.setJobTitle(job.getJobTitle());
			    }
			    if (job.getDescription() != null) {
			        current.setDescription(job.getDescription());
			    }
			    if (job.getRequirments() != null) {
			        current.setRequirments(job.getRequirments());
			    }
			    if (job.getExperience() != 0) {
			        current.setExperience(job.getExperience());
			    }
			    if (job.getWorkHours() != null) {
			        current.setWorkHours(job.getWorkHours());
			    }
			    if (job.getWorkPlaceType() != null) {
			        current.setWorkPlaceType(job.getWorkPlaceType());
			    }
			    if (job.getCategory() != null) {
			        current.setCategory(job.getCategory());
			    }
			    if (job.getStatus() != null) {
			        current.setStatus(job.getStatus());
			    }
			    if (job.getApplicantsCount() != 0) {
			        current.setApplicantsCount(job.getApplicantsCount());
			    }
			    if (job.getDateTime() != null) {
			        current.setDateTime();
			    }
			    if (job.getLocation() != null) {
			        current.setLocation(job.getLocation());
			    }
			    if (job.getCompany() != null) {
			        current.setCompany(job.getCompany());
			    }
			    if (job.getQualification() != null) {
			        current.setQualification(job.getQualification());
			    }
			    if (job.getDepartment() != null) {
			        current.setDepartment(job.getDepartment());
			    }
			    if (job.getCareerLevels() != null) {
			        current.setCareerLevels(job.getCareerLevels());
			    }
			    if (job.getSkills() != null) {
			        current.setSkills(job.getSkills());
			    }
			    if (job.getApplicants() != null) {
			        current.setApplicants(job.getApplicants());
			    }
			    if (job.getTarget() != null) {
			        current.setTarget(job.getTarget());
			    }

			    return jobRepo.save(current);

		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Job not found for ID: " + job.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update job", e);
		}
	}

	@Override
	public boolean deleteJob(int id) {
		// TODO Auto-generated method stub
		try {
			Job job = getJobById(id);
			if (job != null) {
				if (job.getLocation() != null) {
					job.setLocation(null);
				}
				if (job.getCompany() != null) {
//				Company company = company.getIndustryById(company.getIndustry().getId());
					job.setCompany(null);
				}
				for (Qualification qual : new ArrayList<>(job.getQualification())) {
					Qualification q = qualificationService.getQualificationById(qual.getId());
					q.getJobs().remove(job);
					job.getQualification().remove(qual);
					qualificationService.updateQualification(q);
				}
				if (job.getDepartment() != null) {
					Department dep = departmentService.getDepartmentById(job.getDepartment().getId());
					dep.getJobs().remove(job);
					job.setDepartment(null);
					departmentService.updateDepartment(dep);
				}
				for (CareerLevel career : new ArrayList<>(job.getCareerLevels())) {
					CareerLevel c = careerLevelService.getCareerLevelById(career.getId());
					c.getJobs().remove(job);
					job.getCareerLevels().remove(c);
					careerLevelService.updateCareerLevel(c);

				}
				for (Skill skill : new ArrayList<>(job.getSkills())) {
					Skill s = skillService.getSkillById(skill.getId());
					s.getJobs().remove(job);
					job.getSkills().remove(s);
					skillService.updateSkill(s);

				}
				for (User user : new ArrayList<>(job.getApplicants())) {
					user.getAppliedJobs().remove(job);
					job.getApplicants().remove(user);
				}
				jobRepo.deleteById(id);
				return true;
			}
			System.err.println("No Job Can Be Found For ID: " + id);
			return false;
		} catch (Exception e) {
			System.err.println("Cant Delete Job For ID: " + id + "\n" + e);
			return false;
		}

	}

	@Override
	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			return job.get();
		}
		System.err.println("Job Not Fond");
		return null;
	}

	@Override
	public List<Job> findByCompanyId(int companyId) {
		try {
			return jobRepo.findByCompany_Id(companyId);
		} catch (Exception e) {
			System.err.println("Error Getting All Jobs For This Company ID: " + companyId + " \n" + e);
			return null;
		}
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		try {
			return jobRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Jobs " + e);
			return null;
		}
	}

	@Override
	public List<?> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace,
			Integer experience, List<String> skills, List<String> target, List<String> qualification,
			List<String> careerLevel) {
		try {
			return jobRepo.findBySearchFilters(title, workingHour, workPlace, experience, skills, target, qualification,
					careerLevel);
		} catch (Exception e) {
			System.err.println("Error Searching For Job Title " + title + "\n" + e);
			return null;
		}
	}

	@Override
	public List<Job> getAppliedJobsByUserId(int userId) {
		try {
			return jobRepo.findByApplicantsId(userId);
		} catch (Exception e) {
			System.err.println("Error Getting All Applied Jobs For This User ID: " + userId + " \n" + e);
			return null;
		}

	}

}
