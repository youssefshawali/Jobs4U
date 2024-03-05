package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Government;
import com.global.Repository.GovernmentRepo;
import com.global.Services.CityService;
import com.global.Services.GovernmentService;

@Service
public class GovernmentServiceImpl implements GovernmentService {

	@Autowired
	private GovernmentRepo governmentRepo;
	@Autowired
	private CityService cityService;

	@Override
	public List<Government> getAllGovernments() {
		// TODO Auto-generated method stub
		try {
			return governmentRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Governorates " + e);
		}
	}

	@Override
	public Government insertGovernment(Government government) {
		// TODO Auto-generated method stub
		try {
			return governmentRepo.save(government);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Governorate " + e);
		}
	}

	@Override
	public Government updateGovernment(Government government) {
		// TODO Auto-generated method stub
		try {
			Government current = governmentRepo.findById(government.getId()).orElseThrow();
			if (government.getName() != null) {
				current.setName(government.getName());
			}
			return governmentRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Governorate not found for ID: " + government.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update governorate", e);
		}
	}

	@Override
	public boolean deleteGovernment(int id) {
		// TODO Auto-generated method stub
		try {
			governmentRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Governorate For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Government getGovernmentById(int id) {
		// TODO Auto-generated method stub
		Optional<Government> government = governmentRepo.findById(id);
		if (government.isPresent()) {
			return government.get();
		}
		throw new RuntimeException("Governorate Not Fond");
	}

	public City createCity(int governmentId, City city) {
		try {
			Government government = getGovernmentById(governmentId);
			city.setGovernment(government);
			return cityService.insertCity(city);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding City For Governorate ID: " + e);
		}
	}

	@Override
	public List<City> getAllGovCities(int govId) {
		try {
		return cityService.getCityByGovernmentId(govId);
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Cities For This Governorate ID: " + govId + " \n" + e);
		}
	}
}
