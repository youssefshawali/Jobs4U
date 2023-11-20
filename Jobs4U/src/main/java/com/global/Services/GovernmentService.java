package com.global.Services;

import java.util.List;

import com.global.Entity.Government;


public interface GovernmentService {

List<Government> getAllGovernment();
	
Government insertGovernment(Government Government);
	
Government updateGovernment(Government Government);
	
	void deleteGovernment(int id);
	
	Government getGovernmentById(int id);
}
