package com.global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
