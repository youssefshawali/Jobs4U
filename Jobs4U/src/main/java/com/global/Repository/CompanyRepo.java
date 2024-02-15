package com.global.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.global.Entity.Company;
import com.global.Entity.Job;

import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

	@Query("SELECT company FROM Company company WHERE company.name LIKE %?1%")
	List<Company> findAll(String name);
	 Company findByEmail(String email);
}
