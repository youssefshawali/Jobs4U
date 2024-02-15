package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Entity.Qualification;
import com.global.Entity.University;
import com.global.Services.CollegeService;
import com.global.Services.UniversityService;
import com.global.Repository.UniversityRepo;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepo universityRepo;
	@Autowired
	CollegeService collegeService;

	@Override
	public List<University> getAllUniversities() {
		// TODO Auto-generated method stub
		return universityRepo.findAll();
	}

	@Override
	public University insertUniversity(University university) {
		// TODO Auto-generated method stub
		return universityRepo.save(university);
	}

	@Override
	public University updateUniversity(University university) {
		// TODO Auto-generated method stub
		try {
			University current = universityRepo.findById(university.getId()).orElseThrow();
			if (university.getName() != null) {
				current.setName(university.getName());
			}
			return universityRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("university not found for ID: " + university.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update university", e);
		}
	}

	@Override
	public void deleteUniversity(int id) {
		// TODO Auto-generated method stub
		universityRepo.deleteById(id);
	}

	@Override
	public University getUniversityById(int id) {
		// TODO Auto-generated method stub
		Optional<University> university = universityRepo.findById(id);
		if (university.isPresent()) {
			return university.get();
		}
		throw new RuntimeException("University Not Fond");
	}

	@Override
	public College createCollege(int universityId, College college) {
		University university = getUniversityById(universityId);
		college.setUniversity(university);
		return collegeService.insertCollege(college);
	}

}
