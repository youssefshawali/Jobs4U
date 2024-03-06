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
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Services.CollegeService;

import ApiResponse.Response;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	@GetMapping("/")
	public Response<List<College>> getAllColleges() {
		List<College> colleges = collegeService.getAllColleges();
		if (colleges.size() != 0) {
			return new Response<>(200, "Success", colleges);
		} else {
			return new Response<>(404, "No colleges found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<College> getCollege(@PathVariable int id) {
		College college = collegeService.getCollegeById(id);
		if (college != null) {
			return new Response<>(200, "Success", college);
		} else {
			return new Response<>(404, "No college found", null);
		}
	}

	@PostMapping("/")
	public Response<College> saveCollege(@RequestBody College college) {
		College savecollege = collegeService.insertCollege(college);
		if (savecollege != null) {
			return new Response<>(200, "College saved successfully", savecollege);
		} else {
			return new Response<>(404, "Failed to save college", null);
		}
	}

	@PutMapping("/")
	public Response<College> updateCollege(@RequestBody College college) {
		College updatecollege = collegeService.updateCollege(college);
		if (updatecollege != null) {
			return new Response<>(200, "College updated successfully", updatecollege);
		} else {
			return new Response<>(404, "Failed to update college", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteCollege(@PathVariable int id) {

		boolean deleted = collegeService.deleteCollege(id);
		if (deleted) {
			return new Response<>(200, "College  deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete college ", null);
		}
	}

}
