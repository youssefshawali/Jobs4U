package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Company;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{

}
