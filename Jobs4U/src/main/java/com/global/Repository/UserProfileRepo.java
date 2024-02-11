package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.global.Entity.UserProfile;

import org.springframework.stereotype.Repository;
@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer>{

}
