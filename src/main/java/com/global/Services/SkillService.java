package com.global.Services;

import java.util.List;

import com.global.Entity.Skill;
import org.springframework.stereotype.Service;
@Service

public interface SkillService {

List<Skill> getAllSkills();
	
Skill insertSkill(Skill skill);
	
Skill updateSkill (Skill skill);
	
	boolean deleteSkill(int id);
	
	Skill getSkillById(int id);
}
