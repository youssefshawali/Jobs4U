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
import com.global.Entity.University;
import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Services.UniversityService;

import ApiResponse.Response;

@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	private UniversityService universityService;

	@GetMapping("/")
	public Response<List<University>> getAllUniversitys() {

		List<University> universities = universityService.getAllUniversities();
		if (universities.size() != 0) {
			return new Response<>(200, "Success", universities);
		} else {
			return new Response<>(404, "No universities found", null);
		}

	}

	@GetMapping("/{id}")
	public Response<University> getUniversity(@PathVariable int id) {
		University university = universityService.getUniversityById(id);
		if (university != null) {
			return new Response<>(200, "Success", university);
		} else {
			return new Response<>(404, "No university found", null);
		}
	}

	@PostMapping("/")
	public Response<University> saveUniversity(@RequestBody University university) {
		University saveuniversity = universityService.insertUniversity(university);
		if (saveuniversity != null) {
			return new Response<>(200, "University saved successfully", saveuniversity);
		} else {
			return new Response<>(404, "Failed to save university", null);
		}
	}

	@PutMapping("/")
	public Response<University> updateUniversity(@RequestBody University university) {
		University updateuniversity = universityService.updateUniversity(university);
		if (updateuniversity != null) {
			return new Response<>(200, "University updated successfully", updateuniversity);
		} else {
			return new Response<>(404, "Failed to update university", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteUniversity(@PathVariable int id) {
		boolean deleted = universityService.deleteUniversity(id);
		if (deleted) {
			return new Response<>(200, "University  deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete university ", null);
		}
	}

	@PostMapping("/{universityId}/college")
	public Response<College> createCollege(@PathVariable int universityId, @RequestBody College college) {
		College createcollege = universityService.createCollege(universityId, college);
		if (createcollege != null) {
			return new Response<>(200, "College added successfully", createcollege);
		} else {
			return new Response<>(404, "Failed to create college", null);
		}
	}

	@GetMapping("/{uId}/colleges")
	public Response<List<College>> getUniverstyColleges(@PathVariable int uId) {
		List<College> colleges = universityService.getUniverstyColleges(uId);
		if (colleges.size() != 0) {
			return new Response<>(200, "Success", colleges);
		} else {
			return new Response<>(404, "No colleges found", null);
		}
	}
}
