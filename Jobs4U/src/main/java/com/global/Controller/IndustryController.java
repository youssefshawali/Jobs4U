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

import com.global.Entity.Industry;
import com.global.Services.IndustryService;

@RestController
@RequestMapping("/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;
	
	@GetMapping("/")
	public List<Industry> getAllIndustries(){
		return industryService.getAllIndustries();
	}
	
	@GetMapping("/{id}")
	public Industry getIndustry(@PathVariable int id) {
		return industryService.getIndustryById(id);
	}
	
	@PostMapping("/")
	public Industry saveIndustry (@RequestBody Industry industry) {
		return industryService.insertIndustry(industry);
	}
	
	@PutMapping("/")
	public Industry updateIndustry (@RequestBody Industry industry) {
		return industryService.updateIndustry(industry);
	}
	
	@DeleteMapping("/{id}")
	public void deleteIndustry(@PathVariable int id) {
		industryService.deleteIndustry(id);
	}
}
