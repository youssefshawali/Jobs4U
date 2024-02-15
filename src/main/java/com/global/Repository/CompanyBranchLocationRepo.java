package com.global.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.global.Entity.CompanyBranchLocation;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyBranchLocationRepo extends JpaRepository<CompanyBranchLocation,Integer> {

}
