package com.global.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import ApiResponse.Response;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/")
	public Response<List<Job>> getAllJobs() {
		List<Job> jobs = jobService.getAllJobs();
		if (jobs.size() != 0) {
			return new Response<>(200, "Success", jobs);
		} else {
			return new Response<>(404, "No jobs found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Job> getJob(@PathVariable int id) {
		Job job = jobService.getJobById(id);
		if (job != null) {
			return new Response<>(200, "Success", job);
		} else {
			return new Response<>(404, "No job found", null);
		}
	}

	@PostMapping("/")
	public Response<Job> saveJob(@RequestBody Job job) {
		Job savejob = jobService.insertJob(job);
		if (savejob != null) {
			return new Response<>(200, "Job saved successfully", savejob);
		} else {
			return new Response<>(404, "Failed to save Job", null);
		}
	}

	@PutMapping("/")
	public Response<Job> updateJob(@RequestBody Job job) {
		Job updatejob = jobService.updateJob(job);
		if (updatejob != null) {
			return new Response<>(200, "Job updated successfully", updatejob);
		} else {
			return new Response<>(404, "Failed to update Job", null);
		}
	}

//	@DeleteMapping("/{id}")
	// public Response<void> deleteJob(@PathVariable int id) {

	// boolean deleted = jobService.deleteJob(id);
//	    if (deleted) {
//	        return new Response<>(200, "Job  deleted successfully", null);
//	    } else {
//	        return new Response<>(404, "Failed to delete job ", null);
//	    }
	// }

	@GetMapping("/company/{companyId}")
	public Response<List<Job>> getAllJobsByCompanyId(@PathVariable int companyId) {
		// jobTitle="AAAAAAAAAA";
		List<Job> jobs = jobService.findByCompanyId(companyId);
		if (jobs.size() != 0) {
			return new Response<>(200, "Success", jobs);
		} else {
			return new Response<>(404, "No jobs found in this company", null);
		}
	}

	@GetMapping("/applied/{userId}")
	public Response<List<Job>> getAppliedJobsByUserId(@PathVariable int userId) {
		List<Job> appliedJobs = jobService.getAppliedJobsByUserId(userId);
		if (appliedJobs.size() != 0) {
			return new Response<>(200, "Success", appliedJobs);
		} else {
			return new Response<>(404, "No jobs were found for this user", null);
		}
	}
}
