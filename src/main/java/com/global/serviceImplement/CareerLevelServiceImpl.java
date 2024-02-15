package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Entity.User;
import com.global.Repository.CareerLevelRepo;
import com.global.Services.CareerLevelService;

@Service
public class CareerLevelServiceImpl implements CareerLevelService {

	@Autowired
	private CareerLevelRepo careerLevelRepo;

	@Override
	public List<CareerLevel> getAllCareerLevels() {
		// TODO Auto-generated method stub
		return careerLevelRepo.findAll();
	}

	@Override
	public CareerLevel insertCareerLevel(CareerLevel CareerLevel) {
		// TODO Auto-generated method stub
		return careerLevelRepo.save(CareerLevel);
	}

	@Override
	public CareerLevel updateCareerLevel(CareerLevel CareerLevel) {
		// TODO Auto-generated method stub
		try {
			CareerLevel current = careerLevelRepo.findById(CareerLevel.getId()).orElseThrow();
			if (CareerLevel.getLevel() != null) {
				current.setLevel(CareerLevel.getLevel());
			}
			if (CareerLevel.getJobs() != null) {
				current.setJobs(CareerLevel.getJobs());
			}

			return careerLevelRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("CareerLevel not found for ID: " + CareerLevel.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update CareerLevel", e);
		}
	}

	@Override
	public void deleteCareerLevel(int id) {
		// TODO Auto-generated method stub
		careerLevelRepo.deleteById(id);
	}

	@Override
	public CareerLevel getCareerLevelById(int id) {
		// TODO Auto-generated method stub
		Optional<CareerLevel> CareerLevel = careerLevelRepo.findById(id);
		if (CareerLevel.isPresent()) {
			return CareerLevel.get();
		}
		throw new RuntimeException("CareerLevel Not Fond");

	}

}