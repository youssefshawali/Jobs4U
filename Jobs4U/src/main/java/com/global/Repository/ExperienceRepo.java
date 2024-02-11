package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.Experience;
@Repository
public interface ExperienceRepo extends JpaRepository<Experience,Integer> {

}
