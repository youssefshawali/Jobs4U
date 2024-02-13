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
import com.global.Entity.Education;
import com.global.Services.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/")
	public List<College> getAllColleges(){
		return collegeService.getAllColleges();
	}
	
	@GetMapping("/{id}")
	public College getCollege(@PathVariable int id) {
		return collegeService.getCollegeById(id);
	}
	
	@PostMapping("/")
	public College saveCollege (@RequestBody College college) {
		return collegeService.insertCollege(college);
	}
	
	@PutMapping("/")
	public College updateCollege (@RequestBody College college) {
		return collegeService.updateCollege(college);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCollege(@PathVariable int id) {
		collegeService.deleteCollege(id);
	}
	

}
