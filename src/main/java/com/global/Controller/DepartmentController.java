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

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}
	
	@PostMapping("/")
	public Department saveDepartment (@RequestBody Department department) {
		return departmentService.insertDepartment(department);
	}
	
	@PutMapping("/")
	public Department updateDepartment (@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable int id) {
		departmentService.deleteDepartment(id);
	}
}
