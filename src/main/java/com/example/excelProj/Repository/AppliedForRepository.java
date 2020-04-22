package com.example.excelProj.Repository;

import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.AppliedFor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppliedForRepository extends JpaRepository<AppliedFor,Long> {

    @Query(value = "Select * from applied_for where candidate_profile_id=:candidateId AND job_id=:jobId",nativeQuery = true)
    AppliedFor applied(@Param("jobId") Long jobId,@Param("candidateId") Long candidateId);

    @Query("Select new com.example.excelProj.Dto.NotificationDTO(a.job.title,a.candidateProfile.user.name,a.candidateProfile.dp," +
            "a.isNotified,a.appliedDate) " +
            "from  AppliedFor a " +
            "where a.job.companyProfile.user.id=:id ORDER BY a.appliedDate")
    List<NotificationDTO> getNotifications(@Param("id") Long id);


    @Query("select count(*) from   AppliedFor a where a.job.companyProfile.user.id=:id AND a.isNotified=false")
    Long getNotificationsCount(@Param("id") Long id);
}
