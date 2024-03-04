package com.global.serviceImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.Job;
import com.global.Entity.Skill;
import com.global.Services.CompanyService;
import com.global.Services.JobService;
import com.global.Services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private JobService jobService;

	@Override
	public List<?> getAll(Map<String, String> queryParams) {
		String q = queryParams.getOrDefault("q", null);
		List<String> skills = queryParams.containsKey("skills") ? List.of(queryParams.get("skills").split(",")) : null;
		List<String> workPlace = queryParams.containsKey("workPlace") ? List.of(queryParams.get("workPlace").split(","))
				: null;
		List<String> workingHours = queryParams.containsKey("workingHours")
				? List.of(queryParams.get("workingHours").split(","))
				: null;
		List<String> target = queryParams.containsKey("target") ? List.of(queryParams.get("target").split(",")) : null;
		List<String> qualification = queryParams.containsKey("qualification")
				? List.of(queryParams.get("qualification").split(","))
				: null;
		List<String> careerLevels = queryParams.containsKey("careerLevels")
				? List.of(queryParams.get("careerLevels").split(","))
				: null;
		String experienceValue = queryParams.get("experience");
		Integer experience = (experienceValue != null && !experienceValue.isEmpty()) ? Integer.parseInt(experienceValue)
				: null;
		List<Object> list = new ArrayList<>();
		list.addAll(jobService.findBySearchFilters(q, workingHours, workPlace, experience, skills, target,
				qualification, careerLevels));
		System.out.println("Siiiiiizeeee"+list.size());
		return list;
	}

}
