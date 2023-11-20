package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
