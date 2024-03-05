package com.global.Services;

import java.util.List;

import com.global.Entity.Job;

import org.springframework.stereotype.Service;

@Service

public interface JobService {

	Job insertJob(Job job);

	Job updateJob(Job job);

	boolean deleteJob(int id);

	Job getJobById(int id);

	List<Job> getAllJobs();

	List<Job> findByCompanyId(int companyId);

	List<?> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace, Integer experience,
			List<String> skills, List<String> target, List<String> qualification, List<String> careerLevel);

	List<Job> getAppliedJobsByUserId(int userId);

}
