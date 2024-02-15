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

import com.global.Entity.Location;
import com.global.Services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@GetMapping("/")
	public List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable int id) {
		return locationService.getLocationById(id);
	}
	
	@PostMapping("/")
	public Location saveLocation (@RequestBody Location location) {
		return locationService.insertLocation(location);
	}
	
	@PutMapping("/")
	public Location updateLocation (@RequestBody Location location) {
		return locationService.updateLocation(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable int id) {
		locationService.deleteLocation(id);
	}
}
