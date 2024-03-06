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

import ApiResponse.Response;

@RestController
@RequestMapping("/government")
public class GovernmentController {

	@Autowired
	private GovernmentService governmentService;

	@GetMapping("/")
	public Response<List<Government>> getAllGovernments() {
		List<Government> governments = governmentService.getAllGovernments();
		if (governments.size() != 0) {
			return new Response<>(200, "Success", governments);
		} else {
			return new Response<>(404, "No governments found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Government> getGovernment(@PathVariable int id) {
		Government government = governmentService.getGovernmentById(id);
		if (government != null) {
			return new Response<>(200, "Success", government);
		} else {
			return new Response<>(404, "No government found", null);
		}
	}

	@PostMapping("/")
	public Response<Government> saveGovernment(@RequestBody Government government) {
		Government savegovernment = governmentService.insertGovernment(government);
		if (savegovernment != null) {
			return new Response<>(200, "Government saved successfully", savegovernment);
		} else {
			return new Response<>(404, "Failed to save government", null);
		}
	}

	@PostMapping("/{governmentId}/city")
	public Response<City> createCity(@PathVariable int governmentId, @RequestBody City city) {
		City createcity = governmentService.createCity(governmentId, city);
		if (createcity != null) {
			return new Response<>(200, "City added successfully", createcity);
		} else {
			return new Response<>(404, "Failed to create city", null);
		}

	}

	@PutMapping("/")
	public Response<Government> updateGovernment(@RequestBody Government government) {
		Government updategovernment = governmentService.updateGovernment(government);
		if (updategovernment != null) {
			return new Response<>(200, "Government updated successfully", updategovernment);
		} else {
			return new Response<>(404, "Failed to update government", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteGovernment(@PathVariable int id) {

		boolean deleted = governmentService.deleteGovernment(id);
		if (deleted) {
			return new Response<>(200, "Government  deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete government ", null);
		}
	}

	@GetMapping("/{govId}/cities")
	public Response<List<City>> getCityByGovernmentId(@PathVariable int govId) {
		List<City> cities = governmentService.getAllGovCities(govId);
		if (cities.size() != 0) {
			return new Response<>(200, "Success", cities);
		} else {
			return new Response<>(404, "No cities found in this government", null);
		}

	}
}
