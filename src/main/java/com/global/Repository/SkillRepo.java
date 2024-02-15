package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.Skill;

public interface SkillRepo extends JpaRepository <Skill,Integer> {

}
