package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.University;

public interface UniversityRepo extends JpaRepository <University,Integer> {

}
