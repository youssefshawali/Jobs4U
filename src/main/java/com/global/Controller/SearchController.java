package com.global.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Job;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
import com.global.Services.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private JobService jobService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private SearchService searchService;
	
	
	
//	@GetMapping("/")
//	public List<?>getAll(@RequestParam String key,@RequestParam String hours,@RequestParam String workPlace,@RequestParam(required = false) Integer experience,@RequestParam String category){
////		key="MMMMMMMMMM";
////		//key="AAAAAAAAAA";
//	return searchService.getAll(key,hours,workPlace,experience,category);
//	}
	
	@GetMapping("/")
    public List<?> getAll(@RequestParam Map<String, String> queryParams) {
        return searchService.getAll(queryParams);
    }
}
