package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Government;
import com.global.Entity.Industry;
import com.global.Repository.IndustryRepo;
import com.global.Services.IndustryService;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryRepo industryRepo;

	@Override
	public List<Industry> getAllIndustrys() {
		// TODO Auto-generated method stub
		return industryRepo.findAll();
	}

	@Override
	public Industry insertIndustry(Industry Industry) {
		// TODO Auto-generated method stub
		return industryRepo.save(Industry);
	}

	@Override
	public Industry updateIndustry(Industry Industry) {
		// TODO Auto-generated method stub
		Industry current = industryRepo.findById(Industry.getId()).orElseThrow();

		current.setType(Industry.getType());
		
		return industryRepo.save(current);
	}

	@Override
	public void deleteIndustry(int id) {
		// TODO Auto-generated method stub
		industryRepo.deleteById(id);
	}

	@Override
	public Industry getIndustryById(int id) {
		// TODO Auto-generated method stub
		Optional<Industry> Industry = industryRepo.findById(id);
		if(Industry.isPresent()) {
			return Industry.get();
		}
		throw new RuntimeException("User Not Fond");	

	}
}
