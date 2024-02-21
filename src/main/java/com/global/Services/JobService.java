package com.global.Services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.global.Entity.CareerLevel;
import com.global.Entity.Job;

import org.springframework.stereotype.Service;
@Service

public interface JobService {
	
    List<Job> findByCompanyId(int companyId,String jobTitle);
    
    List<Job> findByCompanyName(String companyName);

	List<Job> getAllJobs(String jobTitle);
	List<Job> getAllJobs();
		
	List<Job> findBySearchFilters(String title,String hours,String workPlaceType,Integer experience,String category,String target);
	List<Job> findBySearchFilters(String title,String hours,String workPlaceType,String category,String target);

	
	Job insertJob(Job job);
		
	Job updateJob (Job job);
		
	void deleteJob(int id);
		
	Job getJobById(int id);
	
	
}
