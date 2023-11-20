package com.global.Services;

import java.util.List;


public interface QualificationService {

	List<Qualif> getAllUsers();
	
	User saveUser(User user);
	
	User updateUser (Long id,User user);
	
	void deleteUser(Long id);
	
	User getUser(Long id);
}
