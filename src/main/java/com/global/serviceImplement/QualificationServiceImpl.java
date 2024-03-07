package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		try {
			return qualificationRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Qualifications " + e);
			return null;
		}
	}

	@Override
	public Qualification insertQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		try {
			return qualificationRepo.save(qualification);
		} catch (Exception e) {
			System.err.println("Error Adding Qualification " + e);
			return null;
		}
	}

	@Override
	public Qualification updateQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		try {
			Qualification current = qualificationRepo.findById(qualification.getId()).orElseThrow();
			if (qualification.getDegree() != null) {
				current.setDegree(qualification.getDegree());
			}
			if (qualification.getJobs() != null) {
				current.setJobs(qualification.getJobs());
			}
			return qualificationRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Qualification not found for ID: " + qualification.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update qualification", e);
		}
	}

	@Override
	public boolean deleteQualification(int id) {
		// TODO Auto-generated method stub
		try {
			qualificationRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Qualification For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Qualification getQualificationById(int id) {
		// TODO Auto-generated method stub
		Optional<Qualification> qualification = qualificationRepo.findById(id);
		if (qualification.isPresent()) {
			return qualification.get();
		}
		System.err.println("Qualification Not Fond");
		return null;
	}

}
