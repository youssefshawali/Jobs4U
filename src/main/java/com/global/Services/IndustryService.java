package com.global.Services;

import java.util.List;


import com.global.Entity.Company;
import com.global.Entity.Industry;

import org.springframework.stereotype.Service;
@Service

public interface IndustryService {
	
//Company createCompany(int industryId,Company company);
	
List<Industry> getAllIndustries();
	
Industry insertIndustry(Industry industry);
	
Industry updateIndustry (Industry industry);
	
	void deleteIndustry(int id);
	
	Industry getIndustryById(int id);
}
