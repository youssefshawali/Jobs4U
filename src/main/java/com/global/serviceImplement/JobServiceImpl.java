package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.Job;
import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Services.JobService;
import com.global.Repository.JobRepo;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo jobRepo;


	@Override
	public Job insertJob(Job job) {
		// TODO Auto-generated method stub
		return jobRepo.save(job);
	}

	@Override
	public Job updateJob(Job job) {
		// TODO Auto-generated method stub
		Job current = jobRepo.findById(job.getId()).orElseThrow();
		try {
			current.setJobTitle(job.getJobTitle());
			current.setDescription(job.getDescription());
			current.setRequirments(job.getRequirments());
			current.setExperience(job.getExperience());
			current.setWorkHours(job.getWorkHours());
			current.setWorkPlaceType(job.getWorkPlaceType());
			current.setCategory(job.getCategory());
			current.setStatus(job.getStatus());
			current.setApplicantsCount(job.getApplicantsCount());
			current.setDateTime();
			current.setLocation(job.getLocation());
			current.setCompanyId(job.getCompanyId());
			current.setQualification(job.getQualification());
			current.setDepartment(job.getDepartment());
			current.setCareerLevels(job.getCareerLevels());
			current.setSkills(job.getSkills());
			current.setApplicants(job.getApplicants());
			current.setTarget(job.getTarget());
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
	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		jobRepo.deleteById(id);
	}

	@Override
	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			return job.get();
		}
		throw new RuntimeException("Job Not Fond");
	}

	@Override
	public List<Job> findByCompanyId(int companyId) {
		return jobRepo.findByCompany_Id(companyId);
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public List<Job> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace,
			Integer experience, List<String> skills, List<String> target, List<String> qualification,
			List<String> careerLevel) {
		return jobRepo.findBySearchFilters(title, workingHour, workPlace, experience, skills, target, qualification,
				careerLevel);

	}

}
