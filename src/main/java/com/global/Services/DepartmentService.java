package com.global.Services;

import java.util.List;

import com.global.Entity.Department;


public interface DepartmentService {

	List<Department> getAllDepartments();
	
	Department insertDepartment(Department Department);
	
	Department updateDepartment (Department Department);
	
	void deleteDepartment(int id);
	
	Department getDepartmentById(int id);
}
