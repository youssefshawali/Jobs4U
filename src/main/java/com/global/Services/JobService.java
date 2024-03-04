package com.global.Services;

import java.util.List;


import com.global.Entity.Job;

import org.springframework.stereotype.Service;
@Service

public interface JobService {
	
//    List<Job> findByCompanyId(int companyId,String jobTitle);
    
    List<Job> findByCompanyName(String companyName);

//	List<Job> getAllJobs(String jobTitle);
//	List<Job> getAllJobs();
		
	List<Job> findBySearchFilters(String title,Integer experience,String category);
//	List<Job> findBySearchFilters(String title,String hours,String workPlaceType,String category);

	List<Job> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace, Integer experience,
            List<String> skills, List<String> target, List<String> qualification,
             List<String> careerLevel);

	Job insertJob(Job job);
		
	Job updateJob (Job job);
		
	void deleteJob(int id);
		
	Job getJobById(int id);
	
	
}
