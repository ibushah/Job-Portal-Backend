package com.example.excelProj.Repository;

import com.example.excelProj.Model.AppliedFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliedForRepository extends JpaRepository<AppliedFor,Long> {

    @Query(value = "Select * from applied_for where candidate_profile_id=:candidateId AND job_id=:jobId",nativeQuery = true)
    AppliedFor applied(@Param("jobId") Long jobId,@Param("candidateId") Long candidateId);
}
