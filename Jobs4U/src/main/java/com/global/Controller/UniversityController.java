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

import com.global.Entity.University;
import com.global.Services.UniversityService;

@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	private UniversityService universityService;
	
	@GetMapping("/")
	public List<University> getAllUniversitys(){
		return universityService.getAllUniversities();
	}
	
	@GetMapping("/{id}")
	public University getUniversity(@PathVariable int id) {
		return universityService.getUniversityById(id);
	}
	
	@PostMapping("/")
	public University saveUniversity (@RequestBody University university) {
		return universityService.insertUniversity(university);
	}
	
	@PutMapping("/")
	public University updateUniversity (@RequestBody University university) {
		return universityService.updateUniversity(university);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUniversity(@PathVariable int id) {
		universityService.deleteUniversity(id);
	}
}
