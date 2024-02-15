package com.global.Services;

import java.util.List;

import com.global.Entity.Qualification;



public interface QualificationService {

	
	List<Qualification> getAllQualifications();
	
	Qualification insertQualification(Qualification qualification);
	
	Qualification updateQualification (Qualification qualification);
	
	void deleteQualification(int id);
	
	Qualification getQualificationById(int id);
}
