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
		try {
			return skillRepo.findAll();
		} catch (Exception e) {
			System.err.println("Error Getting All Skills " + e);
			return null;
		}
	}

	@Override
	public Skill insertSkill(Skill skill) {
		// TODO Auto-generated method stub
		try {
			return skillRepo.save(skill);
		} catch (Exception e) {
			System.err.println("Error Adding Skill " + e);
			return null;
		}
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
	public boolean deleteSkill(int id) {
		// TODO Auto-generated method stub
		try {
			skillRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println("Cant Delete Skill For ID: " + id + "\n" + e);
			return false;
		}
	}

	@Override
	public Skill getSkillById(int id) {
		// TODO Auto-generated method stub
		Optional<Skill> skill = skillRepo.findById(id);
		if (skill.isPresent()) {
			return skill.get();
		}
		System.err.println("Skill Not Fond");
		return null;
	}

}
