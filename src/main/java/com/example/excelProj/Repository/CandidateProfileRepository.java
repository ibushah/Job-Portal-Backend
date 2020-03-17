package com.example.excelProj.Repository;

import com.example.excelProj.Model.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {
    @Query(value = "Select * from candidate_profile where user_id=:id",nativeQuery = true)
  public CandidateProfile findByUserId(@Param("id") Long id);
}
