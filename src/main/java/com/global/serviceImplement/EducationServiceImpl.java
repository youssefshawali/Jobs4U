package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Entity.Education;
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
		try {
			return educationRepo.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error Getting All Educations " + e);
		}
	}

	@Override
	public Education insertEducation(Education education) {
		// TODO Auto-generated method stub
		try {
			College college = new College();
			college = collegeService.getCollegeById(education.getCollege().getId());
			education.setCollege(college);
			return educationRepo.save(education);
		} catch (Exception e) {
			throw new RuntimeException("Error Adding Education " + e);
		}
	}

	@Override
	public Education updateEducation(Education education) {
		// TODO Auto-generated method stub
		try {
			Education current = educationRepo.findById(education.getId()).orElseThrow();
			if (education.getStartYear() != 0) {
				current.setStartYear(education.getStartYear());
			}
			if (education.getEndYear() != 0) {
				current.setEndYear(education.getEndYear());
			}
			if (education.getUserProfile() != null) {
				current.setUserProfile(education.getUserProfile());
			}
			if (education.getCollege() != null) {
				current.setCollege(education.getCollege());
			}
			return educationRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("education not found for ID: " + education.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update education", e);
		}
	}

	@Override
	public boolean deleteEducation(int id) {
		try {
			Education edu = getEducationById(id);
			if (edu != null) {
				College college = edu.getCollege();
				if (college != null) {
					college.getEducations().remove(edu);
					edu.setCollege(null);
					collegeService.updateCollege(college);
				}
				UserProfile userProfile = edu.getUserProfile();
				if(userProfile!=null){
					userProfile.getEducation().remove(edu);
					edu.setUserProfile(null);
					
				}
				educationRepo.save(edu);
				educationRepo.deleteById(id);
				return true;
			}
			System.err.println("No Education Can Be Found For ID: " + id);
			return false;
		} catch (Exception e) {
			System.err.println("Cant Delete Education For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Education getEducationById(int id) {
		// TODO Auto-generated method stub
		Optional<Education> education = educationRepo.findById(id);
		if (education.isPresent()) {
			return education.get();
		}
		throw new RuntimeException("Education Not Fond");
	}

}
