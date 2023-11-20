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

import com.global.Entity.Company;
import com.global.Services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/{id}")
	public Company getCompany(@PathVariable int id) {
		return companyService.getCompanyById(id);
	}
	
	@PostMapping("/")
	public Company saveCompany (@RequestBody Company company) {
		return companyService.insertCompany(company);
	}
	
	@PutMapping("/")
	public Company updateCompany (@RequestBody Company company) {
		return companyService.updateCompany(company);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable int id) {
		companyService.deleteCompany(id);
	}
}
