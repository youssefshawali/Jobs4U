package com.global.Services;

import java.util.List;

import com.global.Entity.College;

public interface CollageService {
	
List<Collage> getAllCollages();
	
College insertCollage(College Collage);
	
Collage updateCollage (Collage Collage);
	
	void deleteCollage(int id);
	
	Collage getCollageById(int id);
}
