package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.City;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepo extends JpaRepository <City,Integer> {

}
