package com.global.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.Entity.City;
import com.global.Entity.Location;
import com.global.Entity.Skill;
import com.global.Repository.SkillRepo;
import com.global.Services.SkillService;
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepo SkillRepo;

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return SkillRepo.findAll();
	}

	@Override
	public Skill insertSkill(Skill Skill) {
		// TODO Auto-generated method stub
		return SkillRepo.save(Skill);
	}

	@Override
	public Skill updateSkill(Skill Skill) {
		// TODO Auto-generated method stub
		Skill current = SkillRepo.findById(Skill.getId()).orElseThrow();

		current.setName(Skill.getName());
		
		return SkillRepo.save(current);
	}

	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		SkillRepo.deleteById(id);
	}

	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		Optional<Skill> Skill = SkillRepo.findById(id);
		if(Skill.isPresent()) {
			return Skill.get();
		}
		throw new RuntimeException("User Not Fond");
	}
	

}
