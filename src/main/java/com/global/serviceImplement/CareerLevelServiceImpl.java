package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Repository.CareerLevelRepo;
import com.global.Services.CareerLevelService;
import com.global.Services.IndustryCompanyService;

@Service
public class CareerLevelServiceImpl implements CareerLevelService {

	@Autowired
	private CareerLevelRepo careerLevelRepo;

	@Override
	public List<CareerLevel> getAllCareerLevels() {
		// TODO Auto-generated method stub
		try {
			return careerLevelRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Career Levels " + e);
			return null;
		}
	}

	@Override
	public CareerLevel insertCareerLevel(CareerLevel careerLevel) {
		// TODO Auto-generated method stub
		try {
			return careerLevelRepo.save(careerLevel);
		} catch (Exception e) {
			System.err.println("Error Adding Career Level " + e);
			return null;
		}

	}

	@Override
	public CareerLevel updateCareerLevel(CareerLevel careerLevel) {
		// TODO Auto-generated method stub
		try {
			CareerLevel current = careerLevelRepo.findById(careerLevel.getId()).orElseThrow();
			if (careerLevel.getLevel() != null) {
				current.setLevel(careerLevel.getLevel());
			}
			if (careerLevel.getJobs() != null) {
				current.setJobs(careerLevel.getJobs());
			}

			return careerLevelRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("CareerLevel not found for ID: " + careerLevel.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update CareerLevel", e);
		}
	}


	@Override
	public boolean deleteCareerLevel(int id) {
		// TODO Auto-generated method stub
		try {
			careerLevelRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Career Level For ID: "+id +"\n"+e);
			return false;
		}
	}

	@Override
	public CareerLevel getCareerLevelById(int id) {
		// TODO Auto-generated method stub
		Optional<CareerLevel> careerLevel = careerLevelRepo.findById(id);
		if (careerLevel.isPresent()) {
			return careerLevel.get();
		}
		System.err.println("CareerLevel Not Fond");
		return null;

	}

}
