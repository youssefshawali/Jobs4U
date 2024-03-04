package com.global.Services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service

public interface SearchService {

	 List<?> getAll(Map<String, String> queryParams);

}
