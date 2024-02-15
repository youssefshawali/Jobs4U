package com.global.serviceImplement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		try {
			Skill current = skillRepo.findById(skill.getId()).orElseThrow();
			if (skill.getName() != null) {
				current.setName(skill.getName());
			}
			if (skill.getJobs() != null) {
				current.setJobs(skill.getJobs());
			}
			if (skill.getUserProfiles() != null) {
				current.setUserProfiles(skill.getUserProfiles());
			}
			return skillRepo.save(current);
		} catch (NoSuchElementException e) {
			// Handle the case where the experience with the given ID is not found
			throw new RuntimeException("skill not found for ID: " + skill.getId());
		} catch (Exception e) {
			// Handle other exceptions that might occur during the update process
			throw new RuntimeException("Failed to update skill", e);
		}
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
		throw new RuntimeException("Skill Not Fond");
	}

}
