package com.example.excelProj.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String field;

    @Column
    String description;

    @Column
    Long salary;

    @Column
    Date datePosted;

    @Column
    Long jobPosterId;

    @ManyToMany
    @JoinTable(
            name = "applied_for",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    List<CandidateProfile> candidateProfileList;


    public Job(String title, String field, String description, Long salary, Date datePosted) {
        this.title = title;
        this.field = field;
        this.description = description;
        this.salary = salary;
        this.datePosted = datePosted;
    }

    public Job() {
    }


    public Long getJobPosterId() {
        return jobPosterId;
    }

    public void setJobPosterId(Long jobPosterId) {
        this.jobPosterId = jobPosterId;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<CandidateProfile> getCandidateProfileList() {
        return candidateProfileList;
    }

    public void setCandidateProfileList(List<CandidateProfile> candidateProfileList) {
        this.candidateProfileList = candidateProfileList;
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