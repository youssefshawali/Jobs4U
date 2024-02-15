package com.global.Services;

import java.util.List;

import com.global.Entity.Qualification;



public interface QualificationService {

	
	List<Qualification> getAllQualifications();
	
	Qualification insertQualification(Qualification Qualification);
	
	Qualification updateQualification (Qualification Qualification);
	
	void deleteQualification(int id);
	
	Qualification getQualificationById(int id);
}
