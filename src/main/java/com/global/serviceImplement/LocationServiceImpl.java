package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.City;
import com.global.Entity.Location;
import com.global.Repository.LocationRepo;
import com.global.Services.CityService;
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

	@Autowired
	CityService cityService;

	@Override
	public Location insertLocation(Location location) {
		// TODO Auto-generated method stub
		City city = cityService.getCityById(location.getCity().getId());
		location.setCity(city);
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		try {
			Location current = locationRepo.findById(location.getId()).orElseThrow();
			if (location.getStreetName() != null) {
				current.setStreetName(location.getStreetName());
			}
			if (location.getFloorNumber() != 0) {
				current.setFloorNumber(location.getFloorNumber());
			}
			if (location.getApartmentNumber() != 0) {
				current.setApartmentNumber(location.getApartmentNumber());
			}
			if (location.getBuildingNumber() != 0) {
				current.setBuildingNumber(location.getBuildingNumber());
			}
			if (location.getZipCode() != 0) {
				current.setZipCode(location.getZipCode());
			}

			return locationRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("location not found for ID: " + location.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update location", e);
		}
	}

	@Override
	public void deleteLocation(int id) {
	    Location loc = getLocationById(id);
	    if (loc != null) {
	        City city = cityService.getCityById(loc.getCity().getId());
	        if (city != null) {
	            // Remove association between Location and City
	            city.getLocations().remove(loc);
	            loc.setCity(null);
	            // Save the updated City entity
	            cityService.updateCity(city);
	            locationRepo.save(loc);
	        }
	        // Delete the Location entity
	        locationRepo.deleteById(id);
	    }
	}


	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		Optional<Location> location = locationRepo.findById(id);
		if (location.isPresent()) {
			return location.get();
		}
		throw new RuntimeException("Location Not Fond");
	}

	public List<Location> getLocationByCompanyId(int companyId) {
		return locationRepo.findByCompany_Id(companyId);
	}

}
