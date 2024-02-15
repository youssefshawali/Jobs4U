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

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/")
	public List<City> getAllCities(){
		return cityService.getAllCities();
	}
	
	@GetMapping("/{id}")
	public City getCity(@PathVariable int id) {
		return cityService.getCityById(id);
	}
	
	@PostMapping("/")
	public City saveCity (@RequestBody City city) {
		return cityService.insertCity(city);
	}
	
	@PutMapping("/")
	public City updateCity (@RequestBody City city) {
		return cityService.updateCity(city);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCity(@PathVariable int id) {
		cityService.deleteCity(id);
	}
}
