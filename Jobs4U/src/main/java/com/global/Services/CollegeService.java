package com.global.Services;

import java.util.List;

import com.global.Entity.College;
import com.global.Entity.Education;

public interface CollegeService {

	List<College> getAllColleges();

	Education createEducation(int collegeId, Education education);

	College insertCollege(College Collage);

	College updateCollege(College Collage);

	void deleteCollege(int id);

	College getCollegeById(int id);
}
