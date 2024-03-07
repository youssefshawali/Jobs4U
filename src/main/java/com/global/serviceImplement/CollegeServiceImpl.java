package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Services.CollegeService;
import com.global.Repository.CollegeRepo;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepo collegeRepo;

	@Override

	public List<College> getAllColleges() {
		// TODO Auto-generated method stub
		try {
			return collegeRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Colleges " + e);
			return null;
		}
	}

	@Override
	public College insertCollege(College college) {
		// TODO Auto-generated method stub
		try {
			return collegeRepo.save(college);
		} catch (Exception e) {
			System.err.println("Error Adding College " + e);
			return null;
		}
	}

	@Override
	public College updateCollege(College college) {
		// TODO Auto-generated method stub
		try {
			College current = collegeRepo.findById(college.getId()).orElseThrow();
			if (college.getName() != null) {
				current.setName(college.getName());
			}
			if (college.getUniversity() != null) {
				current.setUniversity(college.getUniversity());
			}
			if (college.getEducations() != null) {
				current.setEducations(college.getEducations());
			}

			return collegeRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("College not found for ID: " + college.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update college", e);
		}
	}

	@Override
	public boolean deleteCollege(int id) {
		// TODO Auto-generated method stub
		try {
			collegeRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete College For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public College getCollegeById(int id) {
		// TODO Auto-generated method stub
		Optional<College> college = collegeRepo.findById(id);
		if (college.isPresent()) {
			return college.get();
		}
		System.err.println("College Not Fond");
		return null;

	}

	@Override
	public List<College> getUniverstyColleges(int uId) {
		try {
			return collegeRepo.findByUniversity_Id(uId);
		} catch (Exception e) {
			System.err.println("Error Getting All Colleges For This Company ID: " + uId + " \n" + e);
			return null;
		}
	}
}
