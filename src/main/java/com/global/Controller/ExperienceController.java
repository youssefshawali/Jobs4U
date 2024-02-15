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

import com.global.Entity.City;
import com.global.Entity.Experience;
import com.global.Services.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;
	@GetMapping("/")
	public List<Experience> getAllExperiences(){
		return experienceService.getAllExperiences();
	}
	
	@GetMapping("/{id}")
	public Experience getExperience(@PathVariable int id) {
		return experienceService.getExperienceById(id);
	}
	
	@PostMapping("/")
	public Experience saveExperience (@RequestBody Experience experience) {
		return experienceService.insertExperience(experience);
	}
	
	@PutMapping("/")
	public Experience updateExperience (@RequestBody Experience experience) {
		return experienceService.updateExperience(experience);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExperience(@PathVariable int id) {
		experienceService.deleteExperience(id);
	}
}
