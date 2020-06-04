package com.example.excelProj.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rehan on 6/4/2020.
 */
@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Long companyId;

    @Column
    Long candidateId;


    @Column
    Long jobId;

    @Column
    String typeOfJob;

    @Column
    Boolean seenOrNot;


    @Column
    Date notificationDate;


    @Column
    String notificateFor;


    public Notifications() {
    }

    public Notifications(Long companyId, Long candidateId, Long jobId, String typeOfJob, Boolean seenOrNot, Date notificationDate, String notificateFor) {
        this.companyId = companyId;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.typeOfJob = typeOfJob;
        this.seenOrNot = seenOrNot;
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

    public Boolean getSeenOrNot() {
        return seenOrNot;
    }

    public void setSeenOrNot(Boolean seenOrNot) {
        this.seenOrNot = seenOrNot;
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

