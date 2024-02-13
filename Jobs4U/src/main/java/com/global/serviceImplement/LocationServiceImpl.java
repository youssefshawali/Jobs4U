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
	public Location insertLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		Location current = locationRepo.findById(location.getId()).orElseThrow();

		current.setStreetName(location.getStreetName());
		current.setFloornumber(location.getFloornumber());
		current.setApartmentnumber(location.getApartmentnumber());
		current.setBuildingnumber(location.getBuildingnumber());
		current.setZipcode(location.getZipcode());

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
		Optional<Location> location = locationRepo.findById(id);
		if (location.isPresent()) {
			return location.get();
		}
		throw new RuntimeException("User Not Fond");
	}

}