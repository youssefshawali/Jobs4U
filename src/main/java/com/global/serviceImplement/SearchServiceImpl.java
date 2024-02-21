package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
import com.global.Services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private JobService jobService;
	@Autowired
	private CompanyService companyService;

	@Override
	public List<?> getAll(String key, String workingHours, String workPlace, Integer experience, String category,String target) {
		// TODO Auto-generated method stub
		
		if(key==null&&workingHours==null&&workPlace==null&&experience==null&&category==null&&target==null) {
			List<Object> list = new ArrayList<>();
			
			list.addAll(jobService.findByCompanyName(key));
			list.addAll(companyService.getAllCompanies(key));
			return list;
			
		}
		else if (experience != null) {
			List<Object> list = new ArrayList<>();
			list.addAll(jobService.findBySearchFilters(key, workingHours, workPlace, experience, category,target));
			
			list.addAll(jobService.findByCompanyName(key));
			list.addAll(companyService.getAllCompanies(key));

			return list;
		} else {
			List<Object> list = new ArrayList<>();
			list.addAll(jobService.findBySearchFilters(key, workingHours, workPlace, category,target));
			list.addAll(jobService.findByCompanyName(key));
			list.addAll(companyService.getAllCompanies(key));
			return list;
		}
	}

	

	
}
