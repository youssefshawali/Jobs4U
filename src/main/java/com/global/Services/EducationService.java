package com.global.Services;

import java.util.List;

import com.global.Entity.Education;

public interface EducationService {
	
List<Education> getAllEducations();
	
Education insertEducation(Education Education);
	
Education updateEducation(Education Education);
	
	void deleteEducation(int id);
	
	Education getEducationById(int id);

}
