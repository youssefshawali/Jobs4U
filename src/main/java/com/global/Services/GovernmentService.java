package com.global.Services;

import java.util.List;

import com.global.Entity.City;
import com.global.Entity.Government;

import org.springframework.stereotype.Service;
@Service

public interface GovernmentService {

List<Government> getAllGovernments();
	
Government insertGovernment(Government government);
	
Government updateGovernment(Government government);

City createCity(int governmentId, City city);
	
	void deleteGovernment(int id);
	
	Government getGovernmentById(int id);
}
