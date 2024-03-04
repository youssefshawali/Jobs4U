package com.global.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.global.Entity.Job;
import com.global.Entity.Skill;

import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

	   List<Job> findByCompany_Id(int companyId);


	@Query("SELECT job FROM Job job " + "JOIN job.skills skill " + "LEFT JOIN job.qualification qual "
			+ "JOIN job.careerLevels career " + "WHERE (job.jobTitle LIKE %?1% OR job.company.name LIKE %?1%) "
			+ "AND (?2 IS NULL OR job.workHours IN ?2) " + "AND (?3 IS NULL OR job.workPlaceType IN ?3) "
			+ "AND (?4 IS NULL OR job.experience = ?4) " + "AND (?5 IS NULL OR skill.name IN ?5) "
			+ "AND (?6 IS NULL OR job.target IN ?6) " + "AND (?7 IS NULL OR qual.degree IN ?7) "
			+ "or (?8 IS NULL OR career.level IN ?8)")
	List<Job> findBySearchFilters(String title, List<String> workingHour, List<String> workPlace, Integer experience,
			List<String> skills, List<String> target, List<String> qualification, List<String> careerLevel);
	
	

}
