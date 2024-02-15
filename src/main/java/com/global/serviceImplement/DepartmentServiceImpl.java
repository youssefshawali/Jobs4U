package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.global.Entity.Department;
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
		try {
			Department current = departmentRepo.findById(department.getId()).orElseThrow();
			if (department.getField() != null) {
				current.setField(department.getField());
			}
			if (department.getJobs() != null) {
				current.setJobs(department.getJobs());
			}

			return departmentRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("Department not found for ID: " + department.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update department", e);
		}
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
		throw new RuntimeException("Department Not Fond");
	}
}
