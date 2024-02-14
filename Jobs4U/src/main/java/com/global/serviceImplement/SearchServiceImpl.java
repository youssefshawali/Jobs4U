package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Job;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
import com.global.Services.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private JobService jobService;
	@Autowired
	private CompanyService companyService;
	
	
	@Override
	public List<Object> getAll(String key) {
		if(key!=null) {
		List<Object> list=new ArrayList<>();

		list.addAll(jobService.getAllJobs(key));
		list.addAll(companyService.getAllCompanies(key));
		
		return list;
		}else {

			List<Object> list=new ArrayList<>();
			list.addAll(jobService.getAllJobs(key));
			return list;
			}
		}
	

}
