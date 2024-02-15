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
		return governmentRepo.findAll();
	}

	@Override
	public Government insertGovernment(Government government) {
		// TODO Auto-generated method stub
		return governmentRepo.save(government);
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
			throw new RuntimeException("government not found for ID: " + government.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update government", e);
		}
	}

	@Override
	public void deleteGovernment(int id) {
		// TODO Auto-generated method stub
		governmentRepo.deleteById(id);
	}

	@Override
	public Government getGovernmentById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Optional<Government> government = governmentRepo.findById(id);
		if (government.isPresent()) {
			return government.get();
		}
		throw new RuntimeException("Government Not Fond");
	}

	public City createCity(int governmentId, City city) {
		Government government = getGovernmentById(governmentId);
		city.setGovernment(government);

		/*
		 * List<Education> educations = userProfile.getEducation(); if (educations !=
		 * null) { for (Education education : educations) { // Set the UserProfile for
		 * each Education education.setUserProfile(userProfile); // Optionally, you can
		 * save each Education here // educationRepo.save(education); } }
		 */

		// Save the UserProfile with its associated Education entries
		return cityService.insertCity(city);
	}

}
