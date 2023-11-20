package com.global.Services;

import java.util.List;

import com.global.Entity.Qualification;



public interface QualificationService {

	
	List<Qualification> getAllQualification();
	
	Qualification insertQualification(Qualification Qualification);
	
	Qualification updateQualification (Qualification Qualification);
	
	void deleteQualification(int id);
	
	Qualification findQualificationById(int id);
}
