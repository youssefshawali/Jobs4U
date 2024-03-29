package com.global.Services;

import java.util.List;

import com.global.Entity.Qualification;


import org.springframework.stereotype.Service;
@Service

public interface QualificationService {

	
	List<Qualification> getAllQualifications();
	
	Qualification insertQualification(Qualification qualification);
	
	Qualification updateQualification (Qualification qualification);
	
	boolean deleteQualification(int id);
	
	Qualification getQualificationById(int id);
}
