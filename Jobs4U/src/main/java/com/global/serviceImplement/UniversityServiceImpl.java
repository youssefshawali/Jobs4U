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
	private UniversityRepo UniversityRepo;
	@Override
	public List<University> getAllUniversities() {
		// TODO Auto-generated method stub
		return UniversityRepo.findAll();
	}

	@Override
	public University insertUniversity(University University) {
		// TODO Auto-generated method stub
		return UniversityRepo.save(University);
	}

	@Override
	public University updateUniversity(University University) {
		// TODO Auto-generated method stub
		University current = UniversityRepo.findById(University.getId()).orElseThrow();

		current.setName(University.getName());
		
		return UniversityRepo.save(current);
	}

	@Override
	public void deleteUniversity(int id) {
		// TODO Auto-generated method stub
		UniversityRepo.deleteById(id);
	}

	@Override
	public University getUniversityById(int id) {
		// TODO Auto-generated method stub
		Optional<University> University = UniversityRepo.findById(id);
		if(University.isPresent()) {
			return University.get();
		}
		throw new RuntimeException("User Not Fond");
	}

}
