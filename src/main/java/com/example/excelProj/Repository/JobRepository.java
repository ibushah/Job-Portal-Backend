package com.example.excelProj.Repository;

import com.example.excelProj.Model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long>,JpaSpecificationExecutor<Job> {
    @Query(value = "Select * from job where job.company_id=:id", nativeQuery = true)
    List<Job> findByEmployeeId(@Param("id") Long id);




    @Query(value = "select * from job where category=:cat", nativeQuery = true)
    Page<Job> findByCategory(@Param("cat") String category, Pageable p);


    @Query(value = "select * from job where category=:cat AND company_id=:id", nativeQuery = true)
    Page<Job> findByCategoryAndCompanyId(@Param("cat") String category, @Param("id") Long id, Pageable p);



    @Query(value = "select * from job where company_id=:id", nativeQuery = true)
    List<Job> findByCompanyId(@Param("id") Long id);

    @Query(value = "select * from job where company_id=:id", nativeQuery = true)
    Page<Job> findJobsByCompanyPaginated(@Param("id") Long id, Pageable pageable);

    @Query(value = "select * from job where recruiter_user_id=:id", nativeQuery = true)
    Page<Job> findJobsByRecruiterPaginated(@Param("id") Long id, Pageable pageable);

    //    @Query(value = "select * from job where city:city",nativeQuery = true)
    Page<Job> findByCity(String city, Pageable pageable);


    @Query(value = "select candidate_profile_id from applied_for where job_id=:id", nativeQuery = true)
    public List<Long> findAllCandidateProfile(@Param("id") Long id);



    @Query(value = "select COUNT(candidate_profile_id) from applied_for where job_id=:id", nativeQuery = true)
    public Integer countOfCandidates(@Param("id") Long id);

    @Modifying
    @Transactional
   @Query(value = "DELETE from applied_for where job_id=:id",nativeQuery = true)
    void deleteAssociatedRecords(@Param("id") Long id);



}
