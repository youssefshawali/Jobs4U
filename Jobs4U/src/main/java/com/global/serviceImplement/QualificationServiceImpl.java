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
public class QualificationServiceImpl implements QualificationService{

	@Autowired
	private QualificationRepo QualificationRepo;

	@Override
	public List<com.global.Entity.Qualification> getAllQualification() {
		// TODO Auto-generated method stub
		return QualificationRepo.findAll();
	}

	@Override
	public Qualification insertQualification(Qualification Qualification) {
		// TODO Auto-generated method stub
		return QualificationRepo.save(Qualification);
	}

	@Override
	public Qualification updateQualification(Qualification Qualification) {
		// TODO Auto-generated method stub
		Qualification current = QualificationRepo.findById(Qualification.getId()).orElseThrow();

		current.setDegree(Qualification.getDegree());
		
		return QualificationRepo.save(current);
	}

	@Override
	public void deleteQualification(int id) {
		// TODO Auto-generated method stub
		QualificationRepo.deleteById(id);
	}

	@Override
	public Qualification findQualificationById(int id) {
		// TODO Auto-generated method stub
		Optional<Qualification> Qualification = QualificationRepo.findById(id);
		if(Qualification.isPresent()) {
			return Qualification.get();
		}
		throw new RuntimeException("User Not Fond");
	}
	
	
}
