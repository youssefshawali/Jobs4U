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

import com.global.Entity.Qualification;
import com.global.Entity.Skill;
import com.global.Services.QualificationService;

import ApiResponse.Response;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	private QualificationService qualificationService;

	@GetMapping("/")
	public Response<List<Qualification>> getAllQualifications() {
		List<Qualification> qualifications = qualificationService.getAllQualifications();
		if (qualifications.size() != 0) {
			return new Response<>(200, "Success", qualifications);
		} else {
			return new Response<>(404, "No qualifications found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Qualification> getQualification(@PathVariable int id) {
		Qualification qualification = qualificationService.getQualificationById(id);
		if (qualification != null) {
			return new Response<>(200, "Success", qualification);
		} else {
			return new Response<>(404, "No qualification found", null);
		}
	}

	@PostMapping("/")
	public Response<Qualification> saveQualification(@RequestBody Qualification qualification) {
		Qualification savequalification = qualificationService.insertQualification(qualification);
		if (savequalification != null) {
			return new Response<>(200, "Qualification saved successfully", savequalification);
		} else {
			return new Response<>(404, "Failed to save qualification", null);
		}
	}

	@PutMapping("/")
	public Response<Qualification> updateQualification(@RequestBody Qualification qualification) {
		Qualification updatequalification = qualificationService.updateQualification(qualification);
		if (updatequalification != null) {
			return new Response<>(200, "Qualification updated successfully", updatequalification);
		} else {
			return new Response<>(404, "Failed to update qualification", null);
		}
	}
	

//	@DeleteMapping("/{id}")
//	public Response<void> deleteQualification(@PathVariable int id) {
//		
//		  boolean deleted = qualificationService.deleteQualification(id);
//		    if (deleted) {
//		        return new Response<>(200, "Qualification  deleted successfully", null);
//		    } else {
//		        return new Response<>(404, "Failed to delete qualification ", null);
//		    }
//	}
}
