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

import ApiResponse.Response;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping("/")
	public Response<List<Location>> getAllLocations() {
		List<Location> locations = locationService.getAllLocations();
		if (locations.size() != 0) {
			return new Response<>(200, "Success", locations);
		} else {
			return new Response<>(404, "No locations found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Location> getLocation(@PathVariable int id) {
		Location location = locationService.getLocationById(id);
		if (location != null) {
			return new Response<>(200, "Success", location);
		} else {
			return new Response<>(404, "No location found", null);
		}
	}

	@PostMapping("/")
	public Response<Location> saveLocation(@RequestBody Location location) {
		Location savelocation = locationService.insertLocation(location);
		if (savelocation != null) {
			return new Response<>(200, "Location saved successfully", savelocation);
		} else {
			return new Response<>(404, "Failed to save skillLocation", null);
		}
	}

	@PutMapping("/")
	public Response<Location> updateLocation(@RequestBody Location location) {
		Location updatelocation = locationService.updateLocation(location);
		if (updatelocation != null) {
			return new Response<>(200, "Location updated successfully", updatelocation);
		} else {
			return new Response<>(404, "Failed to update Location", null);
		}
	}

	// @DeleteMapping("/{id}")
//	public Respons<void> deleteLocation(@PathVariable int id) {

	// boolean deleted =locationService.deleteLocation(id);
//		    if (deleted) {
//		        return new Response<>(200, "Location  deleted successfully", null);
//		    } else {
//		        return new Response<>(404, "Failed to delete Location ", null);
//		    }
	// }
}
