package com.global.Services;

import java.util.List;

import com.global.Entity.College;
import com.global.Entity.University;
import org.springframework.stereotype.Service;
@Service
public interface UniversityService {
	
College createCollege(int universityId, College college);
	
List<University> getAllUniversities();
	
University insertUniversity(University university);
	
University updateUniversity (University university);
	
	void deleteUniversity(int id);
	
	University getUniversityById(int id);
}
