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
	   
	   @Query("SELECT job FROM Job job  WHERE (job.jobTitle LIKE %?1% OR job.company.name LIKE %?1%)   AND job.workHours LIKE %?2% AND job.workPlaceType LIKE %?3% AND job.experience = ?4 AND job.category LIKE %?5% ")
	    List<Job> findBySearchFilters(String title,String hours,String workPlace,Integer experience,String category );
	  
	   @Query("SELECT job FROM Job job WHERE job.jobTitle LIKE %?1% OR job.company.name LIKE %?1%   AND job.workHours LIKE %?2% AND job.workPlaceType LIKE %?3% AND job.category LIKE %?4% ")
	   List<Job> findBySearchFilters(String title,String hours,String workPlace,String category );
	   
	   @Query("SELECT job FROM Job job WHERE job.company.name LIKE %?1%")
	   List<Job> findByCompany_Name(String name);
	   
	   
	   @Query("SELECT job FROM Job job WHERE job.jobTitle LIKE %?1%")
	   List<Job> findAll(String name);

}
