package com.global.Services;

import java.util.List;

import com.global.Entity.City;
import com.global.Entity.Government;


public interface GovernmentService {

List<Government> getAllGovernments();
	
Government insertGovernment(Government Government);
	
Government updateGovernment(Government Government);

City createCity(int governmentId, City city);
	
	void deleteGovernment(int id);
	
	Government getGovernmentById(int id);
}