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

import com.global.Entity.CareerLevel;
import com.global.Services.CareerLevelService;

import ApiResponse.Response;

@RestController
@RequestMapping("/careerLevel")
public class CareerLevelController {

	@Autowired
	private CareerLevelService careerLevelService;
	
	@GetMapping("/")
	public Response<List<CareerLevel>> getAllCareerLevels(){
		List<CareerLevel> careerLevels = careerLevelService.getAllCareerLevels();
		if (careerLevels.size() != 0) {
			return new Response<>(200, "Success", careerLevels);
		} else {
			return new Response<>(404, "No careerLevels found", null);
		}
	}
	
	@GetMapping("/{id}")
	public Response<CareerLevel> getCareerLevel(@PathVariable int id) {
		CareerLevel careerLevel=  careerLevelService.getCareerLevelById(id);
		if (careerLevel != null) {
			return new Response<>(200, "Success", careerLevel);
		} else {
			return new Response<>(404, "No careerLevels found", null);
		}
	}
	
	@PostMapping("/")
	public Response<CareerLevel> saveCareerLevel (@RequestBody CareerLevel careerLevel) {
		CareerLevel savecareerlevel = careerLevelService.insertCareerLevel(careerLevel);
		if (savecareerlevel != null) {
			return new Response<>(200, "CareerLevel saved successfully", savecareerlevel);
		} else {
			return new Response<>(404, "Failed to save careerLevel", null);
		}
	}
	
	@PutMapping("/")
	public Response<CareerLevel> updateCareerLevel (@RequestBody CareerLevel careerLevel) {
		CareerLevel updatecareerlevel = careerLevelService.updateCareerLevel(careerLevel);
		 if (updatecareerlevel != null) {
		        return new Response<>(200, "CareerLevel updated successfully", updatecareerlevel);
		    } else {
		        return new Response<>(404, "Failed to update careerLevel", null);
		    }
	}
	
	@DeleteMapping("/{id}")
	public Response<Void> deleteCareerLevel(@PathVariable int id) {
		
		  boolean deleted = careerLevelService.deleteCareerLevel(id);
		    if (deleted) {
		        return new Response<>(200, "CareerLevel  deleted successfully", null);
		    } else {
		        return new Response<>(404, "Failed to delete careerLevel ", null);
		    }
	}
}
