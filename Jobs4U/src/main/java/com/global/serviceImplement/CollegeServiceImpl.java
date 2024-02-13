package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.College;
import com.global.Entity.Education;
import com.global.Services.CollegeService;
import com.global.Services.EducationService;
import com.global.Repository.CollegeRepo;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepo collegeRepo;

	@Override

	public List<College> getAllColleges() {
		// TODO Auto-generated method stub
		return collegeRepo.findAll();
	}

	@Override
	public College insertCollege(College college) {
		// TODO Auto-generated method stub
		return collegeRepo.save(college);
	}

	@Override
	public College updateCollege(College college) {
		// TODO Auto-generated method stub
		College current = collegeRepo.findById(college.getId()).orElseThrow();

		current.setName(college.getName());
		current.setUniversity(college.getUniversity());
		current.setEducations(college.getEducations());

		return collegeRepo.save(current);
	}

	@Override
	public void deleteCollege(int id) {
		// TODO Auto-generated method stub
		collegeRepo.deleteById(id);
	}

	@Override
	public College getCollegeById(int id) {
		// TODO Auto-generated method stub
		Optional<College> college = collegeRepo.findById(id);
		if (college.isPresent()) {
			return college.get();
		}
		throw new RuntimeException("College Not Fond");

	}


}
