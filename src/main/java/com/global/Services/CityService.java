package com.global.Services;

import java.util.List;

import com.global.Entity.City;


public interface CityService {
	
	List<City> getAllCities();
	
	City insertCity(City city);
		
	City updateCity (City city);
		
	void deleteCity(int id);
		
	City getCityById(int id);
}
