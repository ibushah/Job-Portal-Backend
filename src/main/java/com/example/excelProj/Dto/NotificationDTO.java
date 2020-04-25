package com.example.excelProj.Dto;

import java.io.Serializable;
import java.util.Date;

public class NotificationDTO implements Serializable {

    String jobTitle;
    String candidate;
    byte[] candidateDp;
    Boolean isNotified;
    Date date;
    Long jobId;


    public NotificationDTO(String jobTitle, String candidate, byte[] candidateDp, Boolean isNotified, Date date,Long jobId) {
        this.jobTitle = jobTitle;
        this.candidate = candidate;
        this.candidateDp = candidateDp;
        this.isNotified = isNotified;
        this.date = date;
        this.jobId=jobId;
    }

    public Boolean getNotified() {
        return isNotified;
    }

    public void setNotified(Boolean notified) {
        isNotified = notified;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NotificationDTO() {
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public byte[] getCandidateDp() {
        return candidateDp;
    }

    public void setCandidateDp(byte[] candidateDp) {
        this.candidateDp = candidateDp;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}
