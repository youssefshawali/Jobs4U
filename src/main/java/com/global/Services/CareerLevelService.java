package com.global.Services;

import java.util.List;

import com.global.Entity.CareerLevel;


public interface CareerLevelService {
	
	
	List<CareerLevel> getAllCareerLevels();
	
	CareerLevel insertCareerLevel(CareerLevel careerLevel);
		
	CareerLevel updateCareerLevel (CareerLevel careerLevel);
		
	void deleteCareerLevel(int id);
		
	CareerLevel getCareerLevelById(int id);

}
