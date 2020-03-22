package com.example.excelProj.Repository;

import com.example.excelProj.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Query(value = "Select * from job where job.employee_id=:id",nativeQuery = true)
    List<Job> findByEmployeeId(@Param("id") Long id);


}
