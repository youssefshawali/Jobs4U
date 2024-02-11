package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Government;
import com.global.Repository.GovernmentRepo;
import com.global.Services.GovernmentService;

@Service
public class GovernmentServiceImpl implements GovernmentService {
	
	@Autowired
	private GovernmentRepo governmentRepo;

	@Override
	public List<Government> getAllGovernments() {
		// TODO Auto-generated method stub
		return governmentRepo.findAll();
	}

	@Override
	public Government insertGovernment(Government government) {
		// TODO Auto-generated method stub
		return governmentRepo.save(government);
	}

	@Override
	public Government updateGovernment(Government government) {
		// TODO Auto-generated method stub
		Government current = governmentRepo.findById(government.getId()).orElseThrow();

		current.setName(government.getName());
		
		return governmentRepo.save(current);
	}

	@Override
	public void deleteGovernment(int id) {
		// TODO Auto-generated method stub
		governmentRepo.deleteById(id);
	}

	@Override
	public Government getGovernmentById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Optional<Government> government = governmentRepo.findById(id);
				if(government.isPresent()) {
					return government.get();
				}
				throw new RuntimeException("User Not Fond");	
	}

}
