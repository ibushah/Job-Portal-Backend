package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.Date;
import java.util.List;

public class JobDTO {

    Long id;
    String title;
    String field;
    String description;
    Long salary;
    Date datePosted;
    List<CandidateProfile> candidateProfileList;
    Long jobPosterId;

    public JobDTO() {
    }

    public JobDTO(String title, String field, String description, Long salary, Date datePosted) {
        this.title = title;
        this.field = field;
        this.description = description;
        this.salary = salary;
        this.datePosted = datePosted;
    }


    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public Long getJobPosterId() {
        return jobPosterId;
    }

    public void setJobPosterId(Long jobPosterId) {
        this.jobPosterId = jobPosterId;
    }

    public List<CandidateProfile> getCandidateProfileList() {
        return candidateProfileList;
    }



    public void setCandidateProfileList(List<CandidateProfile> candidateProfileList) {
        this.candidateProfileList = candidateProfileList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}