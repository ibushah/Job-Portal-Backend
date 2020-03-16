package com.example.excelProj.Repository;

import com.example.excelProj.Model.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {
}
