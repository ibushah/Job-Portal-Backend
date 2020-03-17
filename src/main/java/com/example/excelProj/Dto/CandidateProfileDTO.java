package com.example.excelProj.Dto;

import com.example.excelProj.Model.Job;

import java.util.List;

public class CandidateProfileDTO {

    Long id;
    String field;
    String presentationLetter;
    Long candidateForeignId;

    byte[] cv;

    byte[] dp;

    List<Job> jobList;
    public CandidateProfileDTO() {
    }

    public CandidateProfileDTO(String field, String presentationLetter, Long candidateForeignId, byte[] cv, byte[] dp) {
        this.field = field;
        this.presentationLetter = presentationLetter;
        this.candidateForeignId = candidateForeignId;
        this.cv = cv;
        this.dp = dp;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getDp() {
        return dp;
    }

    public void setDp(byte[] dp) {
        this.dp = dp;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPresentationLetter() {
        return presentationLetter;
    }

    public void setPresentationLetter(String presentationLetter) {
        this.presentationLetter = presentationLetter;
    }

    public Long getCandidateForeignId() {
        return candidateForeignId;
    }

    public void setCandidateForeignId(Long candidateForeignId) {
        this.candidateForeignId = candidateForeignId;
    }
}
