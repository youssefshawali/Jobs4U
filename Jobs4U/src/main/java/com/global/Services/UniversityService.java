package com.global.Services;

import java.util.List;

import com.global.Entity.University;

public interface UniversityService {
	
List<University> getAllUniversities();
	
University insertUniversity(University University);
	
University updateUniversity (University University);
	
	void deleteUniversity(int id);
	
	University getUniversityById(int id);
}
