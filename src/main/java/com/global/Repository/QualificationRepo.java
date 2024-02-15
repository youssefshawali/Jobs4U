package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Qualification;
import org.springframework.stereotype.Repository;
@Repository
public interface QualificationRepo extends JpaRepository<Qualification,Integer> {

}
