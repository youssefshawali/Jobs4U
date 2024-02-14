package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Department;
import com.global.Entity.User;
import com.global.Repository.DepartmentRepo;
import com.global.Services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

	@Override
	public Department insertDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepo.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department current = departmentRepo.findById(department.getId()).orElseThrow();
		if(department.getField()!= null) {
		current.setField(department.getField());
		}
		if(department.getJobs()!= null) {
		current.setJobs(department.getJobs());
		}

		return departmentRepo.save(current);
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentRepo.deleteById(id);
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		Optional<Department> department = departmentRepo.findById(id);
		if (department.isPresent()) {
			return department.get();
		}
		throw new RuntimeException("User Not Fond");
	}
}
