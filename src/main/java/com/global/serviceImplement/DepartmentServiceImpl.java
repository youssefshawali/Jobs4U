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
		try {
			return departmentRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Departments " + e);
			return null;
		}
	}

	@Override
	public Department insertDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			return departmentRepo.save(department);
		} catch (Exception e) {
			System.err.println("Error Adding Department " + e);
			return null;
		}
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
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		try {
			departmentRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Department For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		Optional<Department> department = departmentRepo.findById(id);
		if (department.isPresent()) {
			return department.get();
		}
		System.err.println("Department Not Fond");
		return null;
	}
}
