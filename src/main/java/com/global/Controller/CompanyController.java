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
	public Response<List<Company>> getAllCompanies() {
		// name="MMMMMMMMMM";

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
	public Response<Company> saveCompany(@RequestBody Company company) {
		Company savecompany = companyService.insertCompany(company);
		if (savecompany != null) {
			return new Response<>(200, "Company saved successfully", savecompany);
		} else {
			return new Response<>(404, "Failed to save company", null);
		}
	}

	@PutMapping("/")
	public Response<Company> updateCompany(@RequestBody Company company) {
		Company updatecompany = companyService.updateCompany(company);
		if (updatecompany != null) {
			return new Response<>(200, "Company updated successfully", updatecompany);
		} else {
			return new Response<>(404, "Failed to update Company", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteCompany(@PathVariable int id) {
		    boolean deleted = companyService.deleteCompany(id);
	    if (deleted) {
	        return new Response<>(200, "Company  deleted successfully", null);
	    } else {
	        return new Response<>(404, "Failed to delete Company ", null);
	    }
	}

	@PostMapping("/{companyId}/job")
	public Response<Job> createJob(@PathVariable int companyId, @RequestBody Job job) {
		Job createjob = companyService.createJob(companyId, job);
		if (createjob != null) {
			return new Response<>(200, "Job added successfully", createjob);
		} else {
			return new Response<>(404, "Failed to create Job", null);
		}

	}

	@PostMapping("/{companyId}/addLocation")
	public Response<Company> addCompanyLocation(@PathVariable int companyId, @RequestBody Location location) {
		Company company = companyService.addCompanyLocation(companyId, location);
		if (company != null) {
			return new Response<>(200, "Location added successfully", company);
		} else {
			return new Response<>(404, "Failed to add Location", null);
		}

	}

	@GetMapping("/{companyId}/locations")
	public Response<List<Location>> getAllCompanyLocations(@PathVariable int companyId) {
		List<Location> locations = companyService.getAllCompanyLocations(companyId);
		if (locations.size() != 0) {
			return new Response<>(200, "Success", locations);
		} else {
			return new Response<>(404, "No locations found", null);
		}

	}
}
