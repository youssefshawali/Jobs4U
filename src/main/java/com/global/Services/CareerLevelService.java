package com.global.Services;

import java.util.List;

import com.global.Entity.CareerLevel;

import org.springframework.stereotype.Service;
@Service

public interface CareerLevelService {
	
	
	List<CareerLevel> getAllCareerLevels();
	
	CareerLevel insertCareerLevel(CareerLevel careerLevel);
		
	CareerLevel updateCareerLevel (CareerLevel careerLevel);
		
	boolean deleteCareerLevel(int id);
		
	CareerLevel getCareerLevelById(int id);

}
