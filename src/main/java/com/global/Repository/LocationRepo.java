package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Location;
import org.springframework.stereotype.Repository;
@Repository
public interface LocationRepo extends JpaRepository<Location,Integer> {

}
