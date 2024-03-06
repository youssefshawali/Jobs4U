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

import ApiResponse.Response;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping("/")
	public Response<List<Skill>> getAllSkills() {
		List<Skill> skills = skillService.getAllSkills();
		if (skills.size() != 0) {
			return new Response<>(200, "Success", skills);
		} else {
			return new Response<>(404, "No skills found", null);
		}
	}

	@GetMapping("/{id}")
	public Response<Skill> getSkill(@PathVariable int id) {
		Skill skill = skillService.getSkillById(id);
		if (skill != null) {
			return new Response<>(200, "Success", skill);
		} else {
			return new Response<>(404, "No skill found", null);
		}
	}

	@PostMapping("/")
	public Response<Skill> saveSkill(@RequestBody Skill skill) {
		Skill saveskill = skillService.insertSkill(skill);
		if (saveskill != null) {
			return new Response<>(200, "Skill saved successfully", saveskill);
		} else {
			return new Response<>(404, "Failed to save skill", null);
		}
	}

	@PutMapping("/")
	public Response<Skill> updateSkill(@RequestBody Skill skill) {
		Skill updateskill = skillService.updateSkill(skill);
		if (updateskill != null) {
			return new Response<>(200, "Skill updated successfully", updateskill);
		} else {
			return new Response<>(404, "Failed to update skill", null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<Void> deleteSkill(@PathVariable int id) {
		boolean deleted = skillService.deleteSkill(id);
		if (deleted) {
			return new Response<>(200, "Skill  deleted successfully", null);
		} else {
			return new Response<>(404, "Failed to delete skill ", null);
		}
	}
}
