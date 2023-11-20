package com.global.Services;

import java.util.List;

import com.global.Entity.College;

public interface CollageService {
	
List<College> getAllCollages();
	
College insertCollage(College Collage);
	
College updateCollage (College Collage);
	
	void deleteCollage(int id);
	
	College getCollageById(int id);
}
