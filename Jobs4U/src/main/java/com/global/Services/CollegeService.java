package com.global.Services;

import java.util.List;

import com.global.Entity.College;

public interface CollegeService {
	
List<College> getAllColleges();
	
College insertCollege(College Collage);
	
College updateCollege (College Collage);
	
	void deleteCollege(int id);
	
	College getCollegeById(int id);
}
