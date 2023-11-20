package com.global.Services;

import java.util.List;

import com.global.Entity.CareerLevel;


public interface CareerLevelService {
	
	List<CareerLevel> getCareerLevels();
	
	CareerLevel insertCareerLevel(CareerLevel CareerLevel);
		
	CareerLevel updateCareerLevel (CareerLevel CareerLevel);
		
	void deleteCareerLevel(int id);
		
	CareerLevel getCareerLevelById(int id);

}
