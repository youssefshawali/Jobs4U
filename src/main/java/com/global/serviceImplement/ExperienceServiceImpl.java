package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Experience;
import com.global.Entity.Location;
import com.global.Repository.ExperienceRepo;
import com.global.Services.ExperienceService;
import com.global.Services.LocationService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepo experienceRepo;

	@Override
	public List<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		return experienceRepo.findAll();
	}

	@Override
	public Experience insertExperience(Experience experience) {
		// TODO Auto-generated method stub
		return experienceRepo.save(experience);
	}

	@Override
	public Experience updateExperience(Experience experience) {
		// TODO Auto-generated method stub
		try {
			Experience current = experienceRepo.findById(experience.getId()).orElseThrow();
			if (experience.getJobTitle() != null) {
				current.setJobTitle(experience.getJobTitle());
			}
			if (experience.getCompanyName() != null) {
				current.setCompanyName(experience.getCompanyName());
			}
			if (experience.getCompanyLocation() != null) {
				current.setCompanyLocation(experience.getCompanyLocation());
			}
			if (experience.getStartDate() != null) {
				current.setStartDate(experience.getStartDate());
			}
			if (experience.getEndDate() != null) {
				current.setEndDate(experience.getEndDate());
			}
			if (experience.getUserProfile() != null) {
				current.setUserProfile(null);
			}
			return experienceRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Experience not found for ID: " + experience.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update experience", e);
		}
	}

	@Autowired
	LocationService locationService;

	@Override
	public void deleteExperience(int id) {
		Experience exp = getExperienceById(id);
		if (exp != null) {
			Location loc =locationService.getLocationById(exp.getCompanyLocation().getId());
			if (loc != null) {
				System.out.println("LOOOOOOC");
				loc.setExperience(null);// Disassociate the Location from the Experience
				exp.setCompanyLocation(null);
				locationService.updateLocation(loc);
				locationService.deleteLocation(loc.getId()); // Delete the associated Location
				experienceRepo.save(exp);
			}
			experienceRepo.deleteById(id); // Delete the Experience entity
		}
	}

	@Override
	public Experience getExperienceById(int id) {
		// TODO Auto-generated method stub
		Optional<Experience> experience = experienceRepo.findById(id);
		if (experience.isPresent()) {
			return experience.get();
		}
		throw new RuntimeException("Experience Not Fond");

	}

}
