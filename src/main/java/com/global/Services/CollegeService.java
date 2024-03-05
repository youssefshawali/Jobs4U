package com.global.Services;

import java.util.List;

import com.global.Entity.College;
import com.global.Entity.Education;
import org.springframework.stereotype.Service;
@Service

public interface CollegeService {

	List<College> getAllColleges();

	College insertCollege(College collage);

	College updateCollege(College collage);

	boolean deleteCollege(int id);

	College getCollegeById(int id);

	List<College> getUniverstyColleges(int uId);
}
