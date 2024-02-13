package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Entity.Skill;
import com.global.Entity.User;
import com.global.Entity.UserProfile;
import com.global.Repository.EducationRepo;
import com.global.Services.CollegeService;
import com.global.Services.EducationService;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepo educationRepo;
   @Autowired
	CollegeService collegeService;
	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return educationRepo.findAll();
	}

	@Override
	public Education insertEducation(Education education) {
		// TODO Auto-generated method stub
		College college = new College();
		college = collegeService.getCollegeById(education.getCollege().getId());
		education.setCollege(college);
		return educationRepo.save(education);
	}

	@Override
	public Education updateEducation(Education education) {
		// TODO Auto-generated method stub
		Education current = educationRepo.findById(education.getId()).orElseThrow();
		current.setStartYear(education.getStartYear());
		current.setEndYear(education.getEndYear());
		current.setUserProfile(education.getUserProfile());
		current.setCollege(education.getCollege());

		return educationRepo.save(current);
	}

	@Override
	public void deleteEducation(int id) {
		// TODO Auto-generated method stub
		educationRepo.deleteById(id);
	}

	@Override
	public Education getEducationById(int id) {
		// TODO Auto-generated method stub
		Optional<Education> education = educationRepo.findById(id);
		if (education.isPresent()) {
			return education.get();
		}
		throw new RuntimeException("User Not Fond");
	}
	
	




}
