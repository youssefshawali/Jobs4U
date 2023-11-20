package com.global.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.College;
import com.global.Services.CollegeService;
import com.global.Repository.CollegeRepo;
@Service
public class CollegeServiceImpl implements CollegeService{

	@Autowired
	private CollegeRepo CollegeRepo;
	
	
	@Override
	
	public List<College> getAllColleges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College insertCollege(College Collage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College updateCollege(College Collage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCollege(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public College getCollegeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
