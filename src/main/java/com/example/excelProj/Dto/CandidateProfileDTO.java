package com.example.excelProj.Dto;

import com.example.excelProj.Model.Job;

import java.util.List;

public class CandidateProfileDTO {

    Long id;
    String field;
    String presentationLetter;
    Long candidateForeignId;
    List<Job> jobList;
    public CandidateProfileDTO() {
    }

    public CandidateProfileDTO(Long id, String field, String presentationLetter, Long candidateForeignId) {
        this.id = id;
        this.field = field;
        this.presentationLetter = presentationLetter;
        this.candidateForeignId = candidateForeignId;
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
