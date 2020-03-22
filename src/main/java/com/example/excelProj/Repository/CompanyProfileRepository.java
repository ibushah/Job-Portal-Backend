package com.example.excelProj.Repository;

import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.Job;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile,Long> {

    CompanyProfile findByUserId(Long id);



}
