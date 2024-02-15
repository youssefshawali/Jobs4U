package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.Department;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
