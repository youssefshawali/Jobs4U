package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.Entity.Company;
import com.global.Entity.Job;

@Repository
public interface SearchRepo extends JpaRepository<Job, Company> {

}
