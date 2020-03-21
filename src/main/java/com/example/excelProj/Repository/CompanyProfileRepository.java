package com.example.excelProj.Repository;

import com.example.excelProj.Model.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile,Long> {
    CompanyProfile findByUserId(Long id);
}
