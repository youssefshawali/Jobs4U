package com.global.Services;

import java.util.List;
import org.springframework.stereotype.Service;
@Service

public interface SearchService {

	List<?>getAll(String key,String wrokingHours,String workPlace,Integer experience,String category);
}
