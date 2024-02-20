package com.global.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.City;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepo extends JpaRepository <City,Integer> {
List<City> findByGovernment_Id(int governmentId);
}
