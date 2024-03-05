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

import com.global.Entity.College;
import com.global.Entity.Company;
import com.global.Entity.Industry;
import com.global.Entity.Job;
import com.global.Services.IndustryService;

import ApiResponse.Response;

@RestController
@RequestMapping("/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;

	@GetMapping("/")
	public Response<List<Industry>> getAllIndustries() {
		List<Industry> industries = industryService.getAllIndustries();

		if (industries.size() != 0) {
			return new Response<>(200, "Success", industries);
		} else {
			return new Response<>(404, "No industries found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Industry> getIndustry(@PathVariable int id) {
		Industry industry = industryService.getIndustryById(id);
		if (industry != null) {
			return new Response<>(200, "Success", industry);
		} else {
			return new Response<>(404, "No industries found", null);
		}
	}

	@PostMapping("/")
	public Response<Industry> saveIndustry(@RequestBody Industry industry) {
		Industry saveindustry =  industryService.insertIndustry(industry);
		if (saveindustry != null) {
			return new Response<>(200, "Industry saved successfully", saveindustry);
		} else {
			return new Response<>(404, "Failed to save Industry", null);
		}
	}

	@PutMapping("/")
	public Response<Industry> updateIndustry(@RequestBody Industry industry) {
		Industry updateindustry = industryService.updateIndustry(industry);
		if (updateindustry != null) {
			return new Response<>(200, "Industry updated successfully", updateindustry);
		} else {
			return new Response<>(404, "Failed to update Industry", null);
		}
	}

	//@DeleteMapping("/{id}")
//	public Response<void> deleteIndustry(@PathVariable int id) {
		
		// boolean deleted = industryService.deleteIndustry(id);
//	    if (deleted) {
//	        return new Response<>(200, "Industry  deleted successfully", null);
//	    } else {
//	        return new Response<>(404, "Failed to delete Industry ", null);
//	    }
	//}

}
