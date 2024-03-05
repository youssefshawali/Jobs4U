package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.College;
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
		try {
			return universityRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Universities " + e);
		}

	}

	@Override
	public University insertUniversity(University university) {
		// TODO Auto-generated method stub
		try {
			return universityRepo.save(university);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding University " +e);
		}

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
	public boolean deleteUniversity(int id) {
		// TODO Auto-generated method stub
		try {
			universityRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete University For ID: " + id + "\n" + e);
			return false;
		}
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
		try {
		University university = getUniversityById(universityId);
		college.setUniversity(university);
		return collegeService.insertCollege(college);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding College For This University ID: " + e);
		}
	}

	@Override
	public List<College> getUniverstyColleges(int uId) {
		try {
			return collegeService.getUniverstyColleges(uId);
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Colleges For This University ID: " + uId + " \n" + e);
		}
	}
}
