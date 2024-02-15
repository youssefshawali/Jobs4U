package com.global.Services;

import java.util.List;

import com.global.Entity.Department;


public interface DepartmentService {

	List<Department> getAllDepartments();
	
	Department insertDepartment(Department department);
	
	Department updateDepartment (Department department);
	
	void deleteDepartment(int id);
	
	Department getDepartmentById(int id);
}
