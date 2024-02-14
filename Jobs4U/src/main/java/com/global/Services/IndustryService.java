package com.global.Services;

import java.util.List;


import com.global.Entity.Company;
import com.global.Entity.Industry;


public interface IndustryService {
	
//Company createCompany(int industryId,Company company);
	
List<Industry> getAllIndustries();
	
Industry insertIndustry(Industry Industry);
	
Industry updateIndustry (Industry Industry);
	
	void deleteIndustry(int id);
	
	Industry getIndustryById(int id);
}
