package com.global.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Department;
import com.global.Services.DepartmentService;

import ApiResponse.Response;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/")
	public Response<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		if (departments.size() != 0) {
			return new Response<>(200, "Success", departments);
		} else {
			return new Response<>(404, "No departments found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Department> getDepartment(@PathVariable int id) {
		Department department = departmentService.getDepartmentById(id);
		if (department != null) {
			return new Response<>(200, "Success", department);
		} else {
			return new Response<>(404, "No department found", null);
		}

	}

	@PostMapping("/")
	public Response<Department> saveDepartment(@RequestBody Department department) {
		Department savedepartment = departmentService.insertDepartment(department);
		if (savedepartment != null) {
			return new Response<>(200, "Department saved successfully", savedepartment);
		} else {
			return new Response<>(404, "Failed to save department", null);
		}
	}

	@PutMapping("/")
	public Response<Department> updateDepartment(@RequestBody Department department) {
		Department updatedepartment = departmentService.updateDepartment(department);
		if (updatedepartment != null) {
			return new Response<>(200, "Department updated successfully", updatedepartment);
		} else {
			return new Response<>(404, "Failed to update department", null);
		}
	}

//	@DeleteMapping("/{id}")
	// public Response<void> deleteDepartment(@PathVariable int id) {
	// boolean deleted = departmentService.deleteDepartment(id);
//	    if (deleted) {
//	        return new Response<>(200, "Department  deleted successfully", null);
//	    } else {
//	        return new Response<>(404, "Failed to delete Department ", null);
//	    }
	// }
}
