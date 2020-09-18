package com.example.excelProj.Repository;

import com.example.excelProj.Dto.TestNotificationsDTO;
import com.example.excelProj.Model.TenderAssortments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TenderAssortmentRepository extends JpaRepository<TenderAssortments,Long> {

    @Query(value = "select * from jobportal.tender_assortments where recruiter_id=:id && notification_for='recruiter'",nativeQuery = true)
    List<TenderAssortments> getTenderNotifications(@Param("id") Long id);
}
