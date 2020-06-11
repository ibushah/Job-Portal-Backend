package com.example.excelProj.Repository;

import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Dto.TestNotificationsDTO;
import com.example.excelProj.Model.Notifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rehan on 6/4/2020.
 */

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications,Long>{

    @Query("Select new com.example.excelProj.Dto.TestNotificationsDTO" +
            "(n.id,n.companyId,n.candidateId,n.jobId,n.typeOfJob,n.seenOrNot,n.notificationDate,n.notificateFor) " +
            "from  Notifications n " +
            "where (n.companyId=:id AND n.notificateFor='notcandidate' AND n.typeOfJob='public') ORDER BY n.notificationDate DESC")
    Page<TestNotificationsDTO> getNotifications(@Param("id") Long id,Pageable pageable);



    @Query("Select new com.example.excelProj.Dto.TestNotificationsDTO" +
            "(n.id,n.companyId,n.candidateId,n.jobId,n.typeOfJob,n.seenOrNot,n.notificationDate,n.notificateFor) " +
            "from  Notifications n " +
            "where (n.candidateId=:id AND n.notificateFor='candidate' AND n.typeOfJob='private') ORDER BY n.notificationDate DESC")
    Page<TestNotificationsDTO> getNotificationsForCandidate(@Param("id") Long id,Pageable pageable);


    @Transactional
    @Modifying
    @Query("update Notifications a " +
            "set " +
            "a.seenOrNot = true where a.companyId=:id")
    void setAllNoticationsAsReadForCompany(@Param("id") Long id);



    @Query("select count(*) from   Notifications a where a.companyId=:id AND a.seenOrNot=false")
    Long getNotificationsCountForCompany(@Param("id") Long id);




    @Transactional
    @Modifying
    @Query("update Notifications a set a.seenOrNot=true where a.companyId=:companyId AND a.jobId=:jobId")
    void setSelectedNotificationAsReadForCompany(@Param("companyId") Long companyId,@Param("jobId") Long jobId);




}
