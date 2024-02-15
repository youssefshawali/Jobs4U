package com.global.Services;

import java.util.List;

import com.global.Entity.Location;


public interface LocationService {

	List<Location> getAllLocations();
	
	Location insertLocation(Location Location);
	
	Location updateLocation (Location Location);
	
	void deleteLocation(int id);
	
	Location getLocationById(int id);
}
