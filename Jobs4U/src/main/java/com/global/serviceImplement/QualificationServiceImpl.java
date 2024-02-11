package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Location;
import com.global.Entity.Qualification;
import com.global.Services.QualificationService;
import com.global.Repository.QualificationRepo;

@Service
public class QualificationServiceImpl implements QualificationService {

	@Autowired
	private QualificationRepo qualificationRepo;

	@Override
	public List<Qualification> getAllQualifications() {
		// TODO Auto-generated method stub
		return qualificationRepo.findAll();
	}

	@Override
	public Qualification insertQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		return qualificationRepo.save(qualification);
	}

	@Override
	public Qualification updateQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		Qualification current = qualificationRepo.findById(qualification.getId()).orElseThrow();

		current.setDegree(qualification.getDegree());
		current.setJobs(qualification.getJobs());

		return qualificationRepo.save(current);
	}

	@Override
	public void deleteQualification(int id) {
		// TODO Auto-generated method stub
		qualificationRepo.deleteById(id);
	}

	@Override
	public Qualification getQualificationById(int id) {
		// TODO Auto-generated method stub
		Optional<Qualification> qualification = qualificationRepo.findById(id);
		if (qualification.isPresent()) {
			return qualification.get();
		}
		throw new RuntimeException("User Not Fond");
	}

}
