package com.global.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Job;
import com.global.Services.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/")
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}

	@GetMapping("/{id}")
	public Job getJob(@PathVariable int id) {
		return jobService.getJobById(id);
	}

	@PostMapping("/")
	public Job saveJob(@RequestBody Job job) {
		return jobService.insertJob(job);
	}

	@PutMapping("/")
	public Job updateJob(@RequestBody Job job) {
		return jobService.updateJob(job);
	}

	@DeleteMapping("/{id}")
	public void deleteJob(@PathVariable int id) {
		jobService.deleteJob(id);
	}

	@GetMapping("/company/{companyId}")
	public List<Job> getAllJobsByCompanyId(@PathVariable int companyId) {
		// jobTitle="AAAAAAAAAA";
		return jobService.findByCompanyId(companyId);
	}
	

}
