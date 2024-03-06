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
import com.global.Services.CityService;

import ApiResponse.Response;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/")
	public Response<List<City>> getAllCities() {
		List<City> cities = cityService.getAllCities();
		if (cities.size() != 0) {
			return new Response<>(200, "Success", cities);
		} else {
			return new Response<>(404, "No cities found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<City> getCity(@PathVariable int id) {
		City city = cityService.getCityById(id);
		if (city != null) {
			return new Response<>(200, "Success", city);
		} else {
			return new Response<>(404, "No city found", null);
		}
	}

	@PostMapping("/")
	public Response<City> saveCity(@RequestBody City city) {
		City savecity = cityService.insertCity(city);
		if (savecity != null) {
			return new Response<>(200, "City saved successfully", savecity);
		} else {
			return new Response<>(404, "Failed to save city", null);
		}
	}

	@PutMapping("/")
	public Response<City> updateCity(@RequestBody City city) {
		City updatecity = cityService.updateCity(city);
		if (updatecity != null) {
			return new Response<>(200, "City updated successfully", updatecity);
		} else {
			return new Response<>(404, "Failed to update city", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteCity(@PathVariable int id) {

		boolean deleted = cityService.deleteCity(id);
		if (deleted) {
			return new Response<>(200, "City  deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete city ", null);
		}
	}
}
