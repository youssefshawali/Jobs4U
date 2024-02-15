package com.global.Services;

import java.util.List;

import com.global.Entity.Skill;

public interface SkillService {

List<Skill> getAllSkills();
	
Skill insertSkill(Skill skill);
	
Skill updateSkill (Skill skill);
	
	void deleteSkill(int id);
	
	Skill getSkillById(int id);
}
