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

import com.global.Entity.Skill;
import com.global.Services.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping("/")
	public List<Skill> getAllSkills(){
		return skillService.getAllSkills();
	}
	
	@GetMapping("/{id}")
	public Skill getSkill(@PathVariable int id) {
		return skillService.getSkillById(id);
	}
	
	@PostMapping("/")
	public Skill saveSkill (@RequestBody Skill skill) {
		return skillService.insertSkill(skill);
	}
	
	@PutMapping("/")
	public Skill updateSkill (@RequestBody Skill skill) {
		return skillService.updateSkill(skill);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSkill(@PathVariable int id) {
		skillService.deleteSkill(id);
	}
}
