package com.example.excelProj.Repository;

import com.example.excelProj.Dto.TestNotificationsDTO;
import com.example.excelProj.Model.TenderAssortments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TenderAssortmentRepository extends JpaRepository<TenderAssortments,Long> {

    @Query(value = "select * from jobportal.tender_assortments where recruiter_id=:id && notification_for='recruiter' ORDER BY tender_assortments.notificationDate DESC",nativeQuery = true)
    List<TenderAssortments> getTenderNotifications(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update * tender_assortments set is_applied=:isApplied where (tender_id=:tenderId AND recruiter_id=:recruiterUserId AND employer_id=:employerUserId)")
    void updateTender(@Param("isApplied") Boolean isApplied,@Param("tenderId") Long tenderId,@Param("recruiterUserId") Long recruiterUserId,@Param("employerUserId") Long employerUserId);
}
