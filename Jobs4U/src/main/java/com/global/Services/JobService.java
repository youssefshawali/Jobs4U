package com.global.Services;

import java.util.List;

import com.global.Entity.Job;


public interface JobService {

	List<Job> getAllJobs();
		
	Job insertJob(Job Job);
		
	Job updateJob (Job Job);
		
	void deleteJob(int id);
		
	Job getJobById(int id);
}
