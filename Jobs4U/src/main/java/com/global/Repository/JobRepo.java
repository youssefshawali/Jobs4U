package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Job;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepo extends JpaRepository<Job,Integer>{

}
