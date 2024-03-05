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
import com.global.Entity.Government;
import com.global.Services.ExperienceService;

import ApiResponse.Response;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;
	@GetMapping("/")
	public Response<List<Experience>> getAllExperiences(){ 
		List<Experience> experiences = experienceService.getAllExperiences();
		if (experiences.size() != 0) {
			return new Response<>(200, "Success", experiences);
		} else {
			return new Response<>(404, "No experiences found", null);
		}
	}
	
	@GetMapping("/{id}")
	public Response<Experience> getExperience(@PathVariable int id) {
		Experience experience = experienceService.getExperienceById(id);
		if (experience  != null) {
			return new Response<>(200, "Success", experience);
		} else {
			return new Response<>(404, "No experience found", null);
		}
	}
	
	@PostMapping("/")
	public Response<Experience> saveExperience (@RequestBody Experience experience) {
		Experience saveexperience = experienceService.insertExperience(experience);
		if (saveexperience != null) {
			return new Response<>(200, "Experience saved successfully", saveexperience);
		} else {
			return new Response<>(404, "Failed to save experience", null);
		}
	}
	
	@PutMapping("/")
	public Response<Experience> updateExperience (@RequestBody Experience experience) {
		Experience	updateexperience = experienceService.updateExperience(experience);
		if (updateexperience != null) {
			return new Response<>(200, "Experience updated successfully", updateexperience);
		} else {
			return new Response<>(404, "Failed to update experience", null);
		}
	}
	
	//@DeleteMapping("/{id}")
	//public Response<void> deleteExperience(@PathVariable int id) {
		
		 //   boolean deleted = experienceService.deleteExperience(id);
//	    if (deleted) {
//	        return new Response<>(200, "Experience  deleted successfully", null);
//	    } else {
//	        return new Response<>(404, "Failed to delete Experience ", null);
//	    }
//	}
}
