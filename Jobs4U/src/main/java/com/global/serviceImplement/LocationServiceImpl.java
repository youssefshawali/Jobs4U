package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Department;
import com.global.Entity.Government;
import com.global.Entity.Location;
import com.global.Repository.LocationRepo;
import com.global.Services.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return locationRepo.findAll();
	}

	@Override
	public Location insertLocation(Location Location) {
		// TODO Auto-generated method stub
		return locationRepo.save(Location);
	}

	@Override
	public Location updateLocation(Location Location) {
		// TODO Auto-generated method stub
		Location current = locationRepo.findById(Location.getId()).orElseThrow();

		current.setLatitude(Location.getLatitude());
		current.setLongitude(Location.getLongitude());
		
		return locationRepo.save(current);
	}

	@Override
	public void deleteLocation(int id) {
		// TODO Auto-generated method stub
		locationRepo.deleteById(id);
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		Optional<Location> Location = locationRepo.findById(id);
		if(Location.isPresent()) {
			return Location.get();
		}
		throw new RuntimeException("User Not Fond");
	}
	
}
