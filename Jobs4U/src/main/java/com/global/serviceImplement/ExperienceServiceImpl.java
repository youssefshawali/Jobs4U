package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Experience;
import com.global.Repository.CityRepo;
import com.global.Repository.ExperienceRepo;
import com.global.Services.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService{

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
		Experience current=experienceRepo.findById(experience.getId()).orElseThrow(); 
		if(experience.getJobTitle()!= null) {
		current.setJobTitle(experience.getJobTitle());
		}
		if(experience.getCompanyName()!= null) {
		current.setCompanyName(experience.getCompanyName());
		}
		if(experience.getCompanyLocation()!= null) {
		current.setCompanyLocation(experience.getCompanyLocation());
		}
		if(experience.getStartDate()!= null) {
		current.setStartDate(experience.getStartDate());
		}
		if(experience.getEndDate()!= null) {
		current.setEndDate(experience.getEndDate());
		}
		if(experience.getUser()!= null) {
		current.setUser(experience.getUser());
		}
		return experienceRepo.save(current);
	}

	@Override
	public void deleteExperience(int id) {
		// TODO Auto-generated method stub
		experienceRepo.deleteById(id);
	}

	@Override
	public Experience getExperienceById(int id) {
		// TODO Auto-generated method stub
		Optional<Experience> Experience = experienceRepo.findById(id);
		if(Experience.isPresent()) {
			return Experience.get();
		}
		throw new RuntimeException("Experience Not Fond");	

	}

}
