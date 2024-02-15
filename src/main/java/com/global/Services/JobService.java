package com.global.Services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.global.Entity.Job;


public interface JobService {
	
    List<Job> findByCompanyId(int companyId,String jobTitle);
    
    List<Job> findByCompanyName(String companyName);

	List<Job> getAllJobs(String jobTitle);
		
	List<Job> findBySearchFilters(String title,String hours,String workPlaceType,Integer experience,String category);
	List<Job> findBySearchFilters(String title,String hours,String workPlaceType,String category);

	
	Job insertJob(Job Job);
		
	Job updateJob (Job Job);
		
	void deleteJob(int id);
		
	Job getJobById(int id);
	
	
}