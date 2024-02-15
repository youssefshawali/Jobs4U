package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.CareerLevel;
import org.springframework.stereotype.Repository;
@Repository
public interface CareerLevelRepo extends JpaRepository<CareerLevel,Integer> {

}
