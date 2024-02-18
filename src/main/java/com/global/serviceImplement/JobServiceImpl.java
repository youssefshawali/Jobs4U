package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Job;
import com.global.Services.JobService;
import com.global.Repository.JobRepo;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo jobRepo;

	@Override
	public List<Job> getAllJobs(String jobTitle) {
		// TODO Auto-generated method stub
		if (jobTitle != null) {
			return jobRepo.findAll(jobTitle);
		} else {
			return jobRepo.findAll();
		}
	}

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
			current.setDateTime(job.getDateTime());
			current.setLocation(job.getLocation());
			current.setCompanyId(job.getCompanyId());
			current.setQualification(job.getQualification());
			current.setDepartment(job.getDepartment());
			current.setCareerLevels(job.getCareerLevels());
			current.setSkills(job.getSkills());
			current.setApplicants(job.getApplicants());
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
	public List<Job> findByCompanyId(int companyId, String jobTitle) {
		if (jobTitle != null) {

			return jobRepo.findByCompany_Id(companyId, jobTitle);
		} else {
			return jobRepo.findByCompany_Id(companyId);
		}
	}

	@Override
	public List<Job> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return jobRepo.findByCompany_Name(companyName);
	}

	@Override
	public List<Job> findBySearchFilters(String title, String hours, String workPlace, Integer experience,
			String category) {
		// TODO Auto-generated method stub
		return jobRepo.findBySearchFilters(title, hours, workPlace, experience, category);
	}

	@Override
	public List<Job> findBySearchFilters(String title, String hours, String workPlace, String category) {
		// TODO Auto-generated method stub
		return jobRepo.findBySearchFilters(title, hours, workPlace, category);
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

}
