package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Qualification;
import com.global.Entity.University;
import com.global.Services.UniversityService;
import com.global.Repository.UniversityRepo;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepo universityRepo;

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
		University current = universityRepo.findById(university.getId()).orElseThrow();

		current.setName(university.getName());

		return universityRepo.save(current);
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
		throw new RuntimeException("User Not Fond");
	}

}
