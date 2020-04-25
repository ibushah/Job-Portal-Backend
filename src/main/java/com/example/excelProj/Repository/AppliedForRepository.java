package com.example.excelProj.Repository;

import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.AppliedFor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface AppliedForRepository extends JpaRepository<AppliedFor,Long> {

    @Query(value = "Select * from applied_for where candidate_profile_id=:candidateId AND job_id=:jobId",nativeQuery = true)
    AppliedFor applied(@Param("jobId") Long jobId,@Param("candidateId") Long candidateId);

    @Query("Select new com.example.excelProj.Dto.NotificationDTO(a.job.title,a.candidateProfile.user.name,a.candidateProfile.dp," +
            "a.isNotified,a.appliedDate,a.job.id) " +
            "from  AppliedFor a " +
            "where a.job.companyProfile.id=:id ORDER BY a.appliedDate DESC")
    Page<NotificationDTO> getNotifications(@Param("id") Long id, Pageable page);


    @Query("select count(*) from   AppliedFor a where a.job.companyProfile.id=:id AND a.isNotified=false")
    Long getNotificationsCount(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query("update AppliedFor a " +
            "set " +
            "a.isNotified = true where a.companyProfile.id=:id")
    void setAllNoticationsAsRead(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update AppliedFor a set a.isNotified=true where a.companyProfile.id=:companyId AND a.job.id=:jobId")
    void setSelectedNotificationAsRead(@Param("companyId") Long companyId,@Param("jobId") Long jobId);
}
