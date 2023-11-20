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
import com.global.Services.QualificationService;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	private QualificationService qualificationService;
	
	@GetMapping("/")
	public List<Qualification> getAllQualifications(){
		return qualificationService.getAllQualifications();
	}
	
	@GetMapping("/{id}")
	public Qualification getQualification(@PathVariable int id) {
		return qualificationService.getQualificationById(id);
	}
	
	@PostMapping("/")
	public Qualification saveQualification (@RequestBody Qualification qualification) {
		return qualificationService.insertQualification(qualification);
	}
	
	@PutMapping("/")
	public Qualification updateQualification (@RequestBody Qualification qualification) {
		return qualificationService.updateQualification(qualification);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQualification(@PathVariable int id) {
		qualificationService.deleteQualification(id);
	}
}
