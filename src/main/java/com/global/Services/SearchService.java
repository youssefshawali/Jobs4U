package com.global.Services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.global.Entity.Job;
@Service

public interface SearchService {

	 List<Job> getAll(Map<String, String> queryParams);

}
