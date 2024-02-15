package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.City;
import com.global.Repository.CityRepo;
import com.global.Services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo cityRepo;

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return cityRepo.findAll();
	}

	@Override
	public City insertCity(City City) {
		// TODO Auto-generated method stub
		return cityRepo.save(City);
	}

	@Override
	public City updateCity(City City) {
		// TODO Auto-generated method stub
		try {
			City current = cityRepo.findById(City.getId()).orElseThrow();
			if (City.getName() != null) {
				current.setName(City.getName());
			}
			if (City.getGovernment() != null) {
				current.setGovernment(City.getGovernment());
			}
			if (City.getLocations() != null) {
				current.setLocations(City.getLocations());
			}
			return cityRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("City not found for ID: " + City.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update City", e);
		}
	}

	@Override
	public void deleteCity(int id) {
		// TODO Auto-generated method stub
		cityRepo.deleteById(id);
	}

	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		Optional<City> City = cityRepo.findById(id);
		if (City.isPresent()) {
			return City.get();
		}
		throw new RuntimeException("City Not Fond");

	}

}
