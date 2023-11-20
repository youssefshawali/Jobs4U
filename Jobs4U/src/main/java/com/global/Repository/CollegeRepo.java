package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.College;


public interface CollegeRepo extends JpaRepository <College,Integer> {

}
