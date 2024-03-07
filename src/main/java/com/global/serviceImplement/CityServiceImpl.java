package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.City;
import com.global.Entity.Government;
import com.global.Repository.CityRepo;
import com.global.Repository.GovernmentRepo;
import com.global.Services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	GovernmentRepo governmentRepo;

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		try {
			return cityRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Cities " + e);
			return null;
		}

	}

	@Override
	public City insertCity(City city) {
		// TODO Auto-generated method stub
		try {
			return cityRepo.save(city);
		} catch (Exception e) {
			System.err.println("Error Adding City " + e);
			return null;
		}

	}

	@Override
	public City updateCity(City city) {
		// TODO Auto-generated method stub
		try {
			City current = cityRepo.findById(city.getId()).orElseThrow();
			if (city.getName() != null) {
				current.setName(city.getName());
			}
			if (city.getGovernment() != null) {
				Government gov = governmentRepo.getById(city.getGovernment().getId());
				city.setGovernment(gov);
				current.setGovernment(city.getGovernment());
			}
			if (city.getLocations() != null) {
				current.setLocations(city.getLocations());
			}
			return cityRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("City not found for ID: " + city.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update City", e);
		}
	}

	@Override
	public boolean deleteCity(int id) {
		// TODO Auto-generated method stub
		try {
			cityRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete City For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		Optional<City> city = cityRepo.findById(id);
		if (city.isPresent()) {
			return city.get();
		}
		System.err.println("City Not Fond");
		return null;

	}

	@Override
	public List<City> getCityByGovernmentId(int governmentId) {
		try {
			return cityRepo.findByGovernment_Id(governmentId);
		} catch (Exception e) {
			System.err.println("Error Getting All Cities For This Governorate ID: " + governmentId + " \n" + e);
			return null;
		}
	}
}
