package com.global.Services;

import java.util.List;

import com.global.Entity.Education;

public interface EducationService {
	
List<Education> getAllEducations();
	
Education insertEducation(Education education);
	
Education updateEducation(Education education);
	
	void deleteEducation(int id);
	
	Education getEducationById(int id);

}
