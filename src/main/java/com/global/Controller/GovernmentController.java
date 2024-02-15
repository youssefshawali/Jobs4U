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
import com.global.Entity.Government;
import com.global.Entity.UserProfile;
import com.global.Services.GovernmentService;

@RestController
@RequestMapping("/government")
public class GovernmentController {

	@Autowired
	private GovernmentService governmentService;
	
	@GetMapping("/")
	public List<Government> getAllGovernments(){
		return governmentService.getAllGovernments();
	}
	
	@GetMapping("/{id}")
	public Government getGovernment(@PathVariable int id) {
		return governmentService.getGovernmentById(id);
	}
	
	@PostMapping("/")
	public Government saveGovernment (@RequestBody Government government) {
		return governmentService.insertGovernment(government);
	}
	@PostMapping("/{governmentId}/city")
	public City createCity(@PathVariable int governmentId, @RequestBody City city) {
		return governmentService.createCity(governmentId, city);
	}
	
	@PutMapping("/")
	public Government updateGovernment (@RequestBody Government government) {
		return governmentService.updateGovernment(government);
	}
	
	@DeleteMapping("/{id}")
	public void deleteGovernment(@PathVariable int id) {
		governmentService.deleteGovernment(id);
	}
}
