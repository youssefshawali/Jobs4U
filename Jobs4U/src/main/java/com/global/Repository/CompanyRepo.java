package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
