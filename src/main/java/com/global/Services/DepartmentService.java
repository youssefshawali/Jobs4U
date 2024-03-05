package com.global.Services;

import java.util.List;

import com.global.Entity.Department;

import org.springframework.stereotype.Service;
@Service

public interface DepartmentService {

	List<Department> getAllDepartments();
	
	Department insertDepartment(Department department);
	
	Department updateDepartment (Department department);
	
	boolean deleteDepartment(int id);
	
	Department getDepartmentById(int id);
}
