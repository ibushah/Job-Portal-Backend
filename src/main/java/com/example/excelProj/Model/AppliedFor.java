package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "applied_for")
public class AppliedFor  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @JsonIgnore
    @ManyToOne
    @JoinColumn
    private CandidateProfile candidateProfile;



    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Job job;

    @Column
    private Boolean isNotified;

    @Column
    Date appliedDate;

    public AppliedFor() {
    }

    public AppliedFor(CandidateProfile candidateProfile, Job job, Boolean isNotified, Date appliedDate) {
        this.candidateProfile = candidateProfile;
        this.job = job;
        this.isNotified = isNotified;
        this.appliedDate = appliedDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CandidateProfile getCandidateProfile() {
        return candidateProfile;
    }

    public void setCandidateProfile(CandidateProfile candidateProfile) {
        this.candidateProfile = candidateProfile;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Boolean getNotified() {
        return isNotified;
    }

    public void setNotified(Boolean notified) {
        isNotified = notified;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }


}
