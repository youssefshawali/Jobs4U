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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.Entity.Company;
import com.global.Entity.Job;
import com.global.Entity.Location;
import com.global.Services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public List<Company> getAllCompanies(){
	//	name="MMMMMMMMMM";
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
	
	@PostMapping("/{companyId}/job")
	public Job createJob(@PathVariable int companyId, @RequestBody Job job)
	{
		return companyService.createJob(companyId, job);
	}
	
	@PostMapping("/{companyId}/addLocation")
	public Company addCompanyLocation(@PathVariable int companyId, @RequestBody Location location)
	{
		return companyService.addCompanyLocation(companyId, location);
	}
}
