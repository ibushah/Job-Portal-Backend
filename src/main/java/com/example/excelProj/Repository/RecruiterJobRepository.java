package com.example.excelProj.Repository;

import com.example.excelProj.Model.RecruiterJobs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Rehan on 5/28/2020.
 */

@Repository
public interface RecruiterJobRepository extends JpaRepository<RecruiterJobs,Long>{

    @Query(value = "select * from recruiter_jobs where company_id=:id",nativeQuery = true)
    Page<RecruiterJobs> findAllJobsByRecruiterCompanyId(@Param("id") Long id, Pageable pageable);


    @Query(value = "select * from recruiter_jobs where category=:cat",nativeQuery = true)
    Page<RecruiterJobs> findByCategory(@Param("cat") String category, Pageable pageable);


}
