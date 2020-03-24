package com.example.excelProj.Repository;

import com.example.excelProj.Dto.AllJobsDTO;
import com.example.excelProj.Model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Query(value = "Select * from job where job.employee_id=:id",nativeQuery = true)
    List<Job> findByEmployeeId(@Param("id") Long id);


    @Query(value = "select new com.example.excelProj.Dto.AllJobsDTO(j.id,j.title,j.description,j.city,cp.logo,cp.logoContentType,j.category, j.longitude, j.latitude) FROM Job j INNER JOIN CompanyProfile cp\n" +
            "ON j.companyProfile.id = cp.id")
    Page<AllJobsDTO> joinAllJobs(Pageable pageable);


    @Query(value="select * from job where category=:cat",nativeQuery = true)
    Page<Job> findByCategory(@Param("cat") String category, Pageable p);


    @Query(value = "select * from job where employee_id=:id",nativeQuery = true)
    List<Job> findByCompanyId(@Param("id") Long id);




}
