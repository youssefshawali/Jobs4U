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

//	@Override
//	public List<Job> getAllJobs(String jobTitle) {
//		// TODO Auto-generated method stub
//		if (jobTitle != null) {
//			return jobRepo.findAll(jobTitle);
//		} else {
//			return jobRepo.findAll();
//		}
//	}

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

//	@Override
//	public List<Job> findByCompanyId(int companyId, String jobTitle) {
//		if (jobTitle != null) {
//
//			return jobRepo.findByCompany_Id(companyId, jobTitle);
//		} else {
//			return jobRepo.findByCompany_Id(companyId);
//		}
//	}

	@Override
	public List<Job> findByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return jobRepo.findByCompany_Name(companyName);
	}

	@Override
	public List<Job> findBySearchFilters(String title, Integer experience, String category) {
		// TODO Auto-generated method stub
		return jobRepo.findBySearchFilters(title, experience, category);
	}
//
//	@Override
//	public List<Job> findBySearchFilters(String title, String hours, String workPlace, String category) {
//		// TODO Auto-generated method stub
//		return jobRepo.findBySearchFilters(title, hours, workPlace, category);
//	}
//
//	@Override
//	public List<Job> getAllJobs() {
//		// TODO Auto-generated method stub
//		return jobRepo.findAll();
//	}

	@Override
	public List<Job> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace, Integer experience,
            List<String> skills, List<String> target, List<String> qualification,
             List<String> careerLevel)
 {
		// Construct the search query based on the provided parameters
		// You may need to handle null values appropriately
	return	jobRepo.findBySearchFilters(title, workingHour, workPlace,experience, skills, target, qualification,careerLevel);
//		List<Job> jobs = jobRepo.findBySearchFilters(title, experience, category);
//		System.out.println("Job Service Size "+jobs.size());
//
//		// Filter jobs based on the list of skills
//		if (skills != null && !skills.isEmpty()) {
//			jobs = jobs.stream().filter(job -> jobContainsAllSkills(job, skills)).collect(Collectors.toList());
//		}
//
//		// Filter jobs based on the list of career levels
//		if (careerLevel != null && !careerLevel.isEmpty()) {
//			jobs = jobs.stream().filter(job -> jobContainsAllCareerLevels(job, careerLevel))
//					.collect(Collectors.toList());
//		}
//		// Filter jobs based on the list of qualifications
//		if (qualification != null && !qualification.isEmpty()) {
//			jobs = jobs.stream().filter(job -> jobContainsAllQualifications(job, qualification))
//					.collect(Collectors.toList());
//		}
//
//		// Filter jobs based on the target
//		if (target == null || target.isEmpty()) {
//			// If no targets are provided, return all jobs
//			return jobs;
//		} else {
//			// Filter jobs based on the target list
//			jobs = jobs.stream().filter(job -> target.stream().anyMatch(targetOb -> job.getTarget().contains(targetOb)))
//					.collect(Collectors.toList());
//		}
//		// Filter jobs based on the workingHours
//		if (workingHour == null || workingHour.isEmpty()) {
//			// If no workingHours are provided, return all jobs
//			return jobs;
//		} else {
//			// Filter jobs based on the workingHour list
//			jobs = jobs.stream().filter(
//					job -> workingHour.stream().anyMatch(workingHourOb -> job.getTarget().contains(workingHourOb)))
//					.collect(Collectors.toList());
//		}
//
//		// Filter jobs based on the workPlace
//		if (workPlace == null || workPlace.isEmpty()) {
//			// If no workPlaces are provided, return all jobs
//			return jobs;
//		} else {
//			// Filter jobs based on the workPlace list
//			jobs = jobs.stream()
//					.filter(job -> workPlace.stream().anyMatch(workPlaceOb -> job.getTarget().contains(workPlaceOb)))
//					.collect(Collectors.toList());
//		}
//
//		// You can add more filters as needed

//		return jobs;
	}

	// Helper method to check if a job contains all the required skills
	private boolean jobContainsAllSkills(Job job, List<String> requiredSkills) {
		List<String> jobSkills = job.getSkills().stream().map(Skill::getName).collect(Collectors.toList());
		return jobSkills.containsAll(requiredSkills);
	}

	// Helper method to check if a job contains the required career levels
	private boolean jobContainsAllCareerLevels(Job job, List<String> requiredCareerLevels) {
		List<String> jobCareerLevels = job.getCareerLevels().stream().map(CareerLevel::getLevel)
				.collect(Collectors.toList());
		return jobCareerLevels.containsAll(requiredCareerLevels);
	}

	// Helper method to check if a job contains all the required qualifications
	private boolean jobContainsAllQualifications(Job job, List<String> requiredQualifications) {
		List<String> jobQualifications = job.getQualification().stream().map(Qualification::getDegree)
				.collect(Collectors.toList());
		return jobQualifications.containsAll(requiredQualifications);
	}

}
