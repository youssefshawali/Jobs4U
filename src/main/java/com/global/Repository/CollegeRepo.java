package com.global.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.College;


public interface CollegeRepo extends JpaRepository <College,Integer> {
		List<College> findByUniversity_Id(int UniversityId);
}
