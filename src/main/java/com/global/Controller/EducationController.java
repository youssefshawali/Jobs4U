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

import com.global.Entity.Education;
import com.global.Services.EducationService;

import ApiResponse.Response;

@RestController
@RequestMapping("/education")
public class EducationController {

	@Autowired
	private EducationService educationService;

	@GetMapping("/")
	public Response<List<Education>> getAllEducations() {
		List<Education> educations = educationService.getAllEducations();
		if (educations.size() != 0) {
			return new Response<>(200, "Success", educations);
		} else {
			return new Response<>(404, "No educations found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Education> getEducation(@PathVariable int id) {
		Education education = educationService.getEducationById(id);
		if (education != null) {
			return new Response<>(200, "Success", education);
		} else {
			return new Response<>(404, "No education found", null);
		}
	}

	@PostMapping("/")
	public Response<Education> saveEducation(@RequestBody Education education) {
		Education saveeducation = educationService.insertEducation(education);
		if (saveeducation != null) {
			return new Response<>(200, "Education saved successfully", saveeducation);
		} else {
			return new Response<>(404, "Failed to save education", null);
		}
	}

	@PutMapping("/")
	public Response<Education> updateEducation(@RequestBody Education education) {
		Education upateeducation = educationService.updateEducation(education);
		if (upateeducation != null) {
			return new Response<>(200, "Education updated successfully", upateeducation);
		} else {
			return new Response<>(404, "Failed to update education", null);
		}
	}

	// @DeleteMapping("/{id}")
	// public void deleteEducation(@PathVariable int id) {

	// boolean deleted =educationService.deleteEducation(id);
//	    if (deleted) {
//	        return new Response<>(200, "Education  deleted successfully", null);
//	    } else {
//	        return new Response<>(404, "Failed to delete Education ", null);
//	    }
//	}

}
