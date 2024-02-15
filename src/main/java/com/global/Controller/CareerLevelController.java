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

@RestController
@RequestMapping("/careerLevel")
public class CareerLevelController {

	@Autowired
	private CareerLevelService careerLevelService;
	
	@GetMapping("/")
	public List<CareerLevel> getAllCareerLevels(){
		return careerLevelService.getAllCareerLevels();
	}
	
	@GetMapping("/{id}")
	public CareerLevel getCareerLevel(@PathVariable int id) {
		return careerLevelService.getCareerLevelById(id);
	}
	
	@PostMapping("/")
	public CareerLevel saveCareerLevel (@RequestBody CareerLevel careerLevel) {
		return careerLevelService.insertCareerLevel(careerLevel);
	}
	
	@PutMapping("/")
	public CareerLevel updateCareerLevel (@RequestBody CareerLevel careerLevel) {
		return careerLevelService.updateCareerLevel(careerLevel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCareerLevel(@PathVariable int id) {
		careerLevelService.deleteCareerLevel(id);
	}
}
