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
import com.global.Services.GovernmentService;

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
	public City insertCity(City city) {
		// TODO Auto-generated method stub
		return cityRepo.save(city);
	}
   @Autowired
  GovernmentRepo governmentRepo;
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
	public void deleteCity(int id) {
		// TODO Auto-generated method stub
		cityRepo.deleteById(id);
	}

	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		Optional<City> city = cityRepo.findById(id);
		if (city.isPresent()) {
			return city.get();
		}
		throw new RuntimeException("City Not Fond");

	}

	@Override
	public List<City> getCityByGovernmentId(int governmentId) {
		return cityRepo.findByGovernment_Id(governmentId);
	}
}
