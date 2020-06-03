package com.example.excelProj.Repository;

import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {
    @Query(value = "Select * from candidate_profile where user_id=:id",nativeQuery = true)
  public CandidateProfile findByUserId(@Param("id") Long id);


    @Query(value = "select * from candidate_profile candp left join user u on candp.user_id=u.id where u.name LIKE %:search%",nativeQuery = true)
    public List<CandidateProfile> search(@Param("search") String search);






}
