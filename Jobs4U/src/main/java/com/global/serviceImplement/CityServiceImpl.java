package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.City;
import com.global.Repository.CityRepo;
import com.global.Services.CityService;
@Service
public class CityServiceImpl implements CityService{

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
		City current = cityRepo.findById(City.getId()).orElseThrow();

		current.setName(City.getName());
		current.setGovernment(City.getGovernment());
		current.setLocation(City.getLocation());
		
		return cityRepo.save(current);
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
		if(City.isPresent()) {
			return City.get();
		}
		throw new RuntimeException("User Not Fond");	

	}

}
