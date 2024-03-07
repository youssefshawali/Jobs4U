package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Experience;
import com.global.Entity.Location;
import com.global.Entity.UserProfile;
import com.global.Repository.ExperienceRepo;
import com.global.Services.ExperienceService;
import com.global.Services.LocationService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepo experienceRepo;
	@Autowired
	LocationService locationService;

	@Override
	public List<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		try {
			return experienceRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Experiences " + e);
			return null;
		}
	}

	@Override
	public Experience insertExperience(Experience experience) {
		// TODO Auto-generated method stub
		try {
			return experienceRepo.save(experience);
		} catch (Exception e) {
			System.err.println("Error Adding Experience " +e);
			return null;
		}

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
		
			return experienceRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Experience not found for ID: " + experience.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update experience", e);
		}
	}


	@Override
	public boolean deleteExperience(int id) {
		try {
			Experience exp = getExperienceById(id);
			if (exp != null) {
				Location loc =exp.getCompanyLocation();
				if (loc != null) {
					loc.setExperience(null);
					locationService.updateLocation(loc);
					locationService.deleteLocation(loc.getId());
				}
				UserProfile userProfile = exp.getUserProfile();
				if(userProfile!=null){
					userProfile.getExperience().remove(exp);
					exp.setUserProfile(null);
					
				}
				experienceRepo.save(exp);
				experienceRepo.deleteById(id);
				return true;
			}
			System.err.println("No Experience Can Be Found For ID: " + id);
			return false;
			
		} catch (Exception e) {
			System.err.println("Cant Delete Experience For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Experience getExperienceById(int id) {
		// TODO Auto-generated method stub
		Optional<Experience> experience = experienceRepo.findById(id);
		if (experience.isPresent()) {
			return experience.get();
		}
		System.err.println("Experience Not Fond");
		return null;

	}

}
