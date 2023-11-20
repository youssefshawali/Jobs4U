package com.global.serviceImplement;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Education;
import com.global.Entity.Skill;
import com.global.Repository.EducationRepo;
import com.global.Services.EducationService;
@Service
public class EducationServiceImpl implements EducationService{

	@Autowired
	private EducationRepo EducationRepo;

	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return EducationRepo.findAll();
	}

	@Override
	public Education insertEducation(Education Education) {
		// TODO Auto-generated method stub
		return EducationRepo.save(Education);
	}

	@Override
	public Education updateEducation(Education Education) {
		// TODO Auto-generated method stub
		Education current = EducationRepo.findById(Education.getId()).orElseThrow();

		current.setStartYear(Education.getStartYear());
		current.setEndYear(Education.getEndYear());
		
		return EducationRepo.save(current);
	}

	@Override
	public void deleteEducation(int id) {
		// TODO Auto-generated method stub
		EducationRepo.deleteById(id);
	}

	@Override
	public Education getEducationById(int id) {
		// TODO Auto-generated method stub
		Optional<Education> Education = EducationRepo.findById(id);
		if(Education.isPresent()) {
			return Education.get();
		}
		throw new RuntimeException("User Not Fond");
	}
	
	
}
