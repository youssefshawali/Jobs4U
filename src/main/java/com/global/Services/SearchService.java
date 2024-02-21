package com.global.Services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.global.Entity.CareerLevel;
@Service

public interface SearchService {

	List<?>getAll(String key,String wrokingHours,String workPlace,Integer experience,String category,String target);
}
