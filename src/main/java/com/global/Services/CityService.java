package com.global.Services;

import java.util.List;

import com.global.Entity.City;

import org.springframework.stereotype.Service;
@Service

public interface CityService {
	
	List<City> getAllCities();
	
	City insertCity(City city);
		
	City updateCity (City city);
		
	boolean deleteCity(int id);
		
	City getCityById(int id);

	List<City> getCityByGovernmentId(int governmentId);
}
