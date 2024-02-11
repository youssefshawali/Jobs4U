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
	private SkillRepo skillRepo;

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return skillRepo.findAll();
	}

	@Override
	public Skill insertSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillRepo.save(skill);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		Skill current = skillRepo.findById(skill.getId()).orElseThrow();

		current.setName(skill.getName());
		current.setJobs(skill.getJobs());
		current.setUserProfiles(skill.getUserProfiles());

		return skillRepo.save(current);
	}

	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		skillRepo.deleteById(id);
	}

	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		Optional<Skill> skill = skillRepo.findById(id);
		if (skill.isPresent()) {
			return skill.get();
		}
		throw new RuntimeException("User Not Fond");
	}

}
