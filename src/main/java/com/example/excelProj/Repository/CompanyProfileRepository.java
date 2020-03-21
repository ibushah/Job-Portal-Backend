package com.example.excelProj.Repository;

import com.example.excelProj.Model.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile,Long> {
    @Query(value = "Select * from company_profile where user_id=:id",nativeQuery = true)
    CompanyProfile findByUserId(Long id);
}
