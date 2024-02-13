package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Education;
import com.global.Entity.Government;
import com.global.Entity.User;
import com.global.Entity.UserProfile;
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
		Government current = governmentRepo.findById(government.getId()).orElseThrow();

		current.setName(government.getName());
		
		return governmentRepo.save(current);
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
				if(government.isPresent()) {
					return government.get();
				}
				throw new RuntimeException("User Not Fond");	
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
