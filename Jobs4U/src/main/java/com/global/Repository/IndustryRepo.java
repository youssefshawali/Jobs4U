package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Industry;
import org.springframework.stereotype.Repository;
@Repository
public interface IndustryRepo extends JpaRepository<Industry,Integer> {

}
