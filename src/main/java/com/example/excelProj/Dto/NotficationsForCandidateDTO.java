package com.example.excelProj.Dto;

import java.io.Serializable;

/**
 * Created by Rehan on 5/28/2020.
 */
public class NotficationsForCandidateDTO implements Serializable{

    byte[] recruiterDp;
    String recruiterName;
    String referedDate;
    String JobTitle;
    Long jobId;
    Boolean isSeen;
    Boolean isApplied;
    Long recruiterId;

    public NotficationsForCandidateDTO(byte[] recruiterDp, String recruiterName, String referedDate, String jobTitle, Long jobId, Boolean isSeen, Boolean isApplied, Long recruiterId) {
        this.recruiterDp = recruiterDp;
        this.recruiterName = recruiterName;
        this.referedDate = referedDate;
        JobTitle = jobTitle;
        this.jobId = jobId;
        this.isSeen = isSeen;
        this.isApplied = isApplied;
        this.recruiterId = recruiterId;
    }

    public NotficationsForCandidateDTO() {
    }

    public byte[] getRecruiterDp() {
        return recruiterDp;
    }

    public void setRecruiterDp(byte[] recruiterDp) {
        this.recruiterDp = recruiterDp;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getReferedDate() {
        return referedDate;
    }

    public void setReferedDate(String referedDate) {
        this.referedDate = referedDate;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }
}
