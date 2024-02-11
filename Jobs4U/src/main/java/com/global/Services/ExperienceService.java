package com.global.Services;

import java.util.List;


import com.global.Entity.Experience;

public interface ExperienceService {

	List<Experience> getAllExperiences();
	

	Experience insertExperience(Experience experience);
		
	Experience updateExperience (Experience experience);
		
	void deleteExperience(int id);
		
	Experience getExperienceById(int id);
}