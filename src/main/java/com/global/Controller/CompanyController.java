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
import com.global.Repository.CompanyRepo;
import com.global.Services.CompanyService;

import ApiResponse.Response;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/")
	public Response<List<Company>> getAllCompanies(){
	//	name="MMMMMMMMMM";
		
		List<Company> companies = companyService.getAllCompanies();
		if (companies.size() != 0) {
			return new Response<>(200, "Success", companies);
		} else {
			return new Response<>(404, "No companies found", null);
		}
	}
	
	
	@GetMapping("/{id}")
	public Response<Company> getCompany(@PathVariable int id) {
		Company company = companyService.getCompanyById(id);
		if (company != null) {
			return new Response<>(200, "Success", company);
		} else {
			return new Response<>(404, "No company found", null);
		}
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
	@GetMapping("/{companyId}/locations")
	public List<Location> getAllCompanyLocations(@PathVariable int companyId){
		return companyService.getAllCompanyLocations(companyId);
	}
}
