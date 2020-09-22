package com.example.excelProj.Repository;

import com.example.excelProj.Model.Tender;
import com.example.excelProj.Model.TenderAssortments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TenderRepository extends JpaRepository<Tender,Long> {

    @Query(value = "select * from tender where id=:id",nativeQuery = true)
    Tender findTender(@Param("id") Long id);


}
