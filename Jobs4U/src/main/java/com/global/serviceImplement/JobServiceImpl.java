package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Job;
import com.global.Entity.User;
import com.global.Entity.Job;
import com.global.Services.JobService;
import com.global.Repository.JobRepo;
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo JobRepo;
	
	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return JobRepo.findAll();
	}

	@Override
	public Job insertJob(Job Job) {
		// TODO Auto-generated method stub
		return JobRepo.save(Job);
	}

	@Override
	public Job updateJob(Job Job) {
		// TODO Auto-generated method stub
		Job current = JobRepo.findById(Job.getId()).orElseThrow();

		current.setJobTitle(Job.getJobTitle());
		current.setApplicantsCount(Job.getApplicantsCount());
		current.setCategory(Job.getCategory());		
		current.setDateTime(Job.getDateTime());
		current.setDescription(Job.getDescription());
		current.setExperience(Job.getExperience());
		current.setLocation(Job.getLocation());
		current.setRequirments(Job.getRequirments());
		current.setStatus(Job.getStatus());
		current.setWorkHours(Job.getWorkHours());
		current.setWorkPlaceType(Job.getWorkPlaceType());
		
		return JobRepo.save(current);
	
	}

	@Override
	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		JobRepo.deleteById(id);
	}

	@Override
	public Job getJobById(int id) {
		// TODO Auto-generated method stub
		Optional<Job> job = JobRepo.findById(id);
		if(job.isPresent()) {
			return job.get();
		}
		throw new RuntimeException("User Not Fond");
	}

}
