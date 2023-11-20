package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Government;
import org.springframework.stereotype.Repository;
@Repository
public interface GovernmentRepo extends JpaRepository<Government,Integer> {

}
