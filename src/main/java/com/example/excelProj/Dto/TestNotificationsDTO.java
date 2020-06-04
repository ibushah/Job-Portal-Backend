package com.example.excelProj.Dto;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Rehan on 6/4/2020.
 */
public class TestNotificationsDTO {
    Long id;

    
    Long companyId;

   
    Long candidateId;


   
    Long jobId;

   
    String typeOfJob;

   
    Boolean isSeen;


   
    Date notificationDate;



    String notificateFor;

    public TestNotificationsDTO() {
    }

    public TestNotificationsDTO(Long id, Long companyId, Long candidateId, Long jobId, String typeOfJob, Boolean isSeen, Date notificationDate, String notificateFor) {
        this.id = id;
        this.companyId = companyId;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.typeOfJob = typeOfJob;
        this.isSeen = isSeen;
        this.notificationDate = notificationDate;
        this.notificateFor = notificateFor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(String typeOfJob) {
        this.typeOfJob = typeOfJob;
    }



    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificateFor() {
        return notificateFor;
    }

    public void setNotificateFor(String notificateFor) {
        this.notificateFor = notificateFor;
    }
}
