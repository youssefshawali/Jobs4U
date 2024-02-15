package com.global.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.global.Entity.Job;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepo extends JpaRepository<Job,Integer>{

	
	   List<Job> findByCompany_Id(int companyId);

	   @Query("SELECT job FROM Job job WHERE job.company.id = ?1 AND job.jobTitle LIKE %?2%")
	   List<Job> findByCompany_Id(int companyId,String name);
	   
	   @Query("SELECT job FROM Job job WHERE job.company.name LIKE %?1%")
	   List<Job> findByCompany_Name(String name);
	   
	   
	   @Query("SELECT job FROM Job job WHERE job.jobTitle LIKE %?1%")
	   List<Job> findAll(String name);

}
