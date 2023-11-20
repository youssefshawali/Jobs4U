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

@RestController
@RequestMapping("/education")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	@GetMapping("/")
	public List<Education> getAllEducations(){
		return educationService.getAllEducations();
	}
	
	@GetMapping("/{id}")
	public Education getEducation(@PathVariable int id) {
		return educationService.getEducationById(id);
	}
	
	@PostMapping("/")
	public Education saveEducation (@RequestBody Education education) {
		return educationService.insertEducation(education);
	}
	
	@PutMapping("/")
	public Education updateEducation (@RequestBody Education education) {
		return educationService.updateEducation(education);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEducation(@PathVariable int id) {
		educationService.deleteEducation(id);
	}
}
