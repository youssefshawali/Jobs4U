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

import com.global.Entity.CompanyBranchLocation;
import com.global.Services.CompanyBranchLocationService;

@RestController
@RequestMapping("/companyBranchLocation")
public class CompanyBranchLocationController {

	@Autowired
	private CompanyBranchLocationService companyBranchLocationService;
	
	@GetMapping("/")
	public List<CompanyBranchLocation> getAllCompanyBranchLocations(){
		return companyBranchLocationService.getAllCompanyBranchLocations();
	}
	
	@GetMapping("/{id}")
	public CompanyBranchLocation getCompanyBranchLocation(@PathVariable int id) {
		return companyBranchLocationService.getCompanyBranchLocationById(id);
	}
	
	@PostMapping("/")
	public CompanyBranchLocation saveCompanyBranchLocation (@RequestBody CompanyBranchLocation companyBranchLocation) {
		return companyBranchLocationService.insertCompanyBranchLocation(companyBranchLocation);
	}
	
	@PutMapping("/")
	public CompanyBranchLocation updateCompanyBranchLocation (@RequestBody CompanyBranchLocation companyBranchLocation) {
		return companyBranchLocationService.updateCompanyBranchLocation(companyBranchLocation);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompanyBranchLocation(@PathVariable int id) {
		companyBranchLocationService.deleteCompanyBranchLocation(id);
	}
}
