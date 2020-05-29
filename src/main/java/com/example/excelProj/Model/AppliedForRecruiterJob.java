package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
@Entity
@Table(name = "applied_or_refered_recruiterJobs")
public class AppliedForRecruiterJob {
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
    private RecruiterJobs recruiterJobs;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;

    @Column
    private Boolean isSeen;

    @Column
    private  Boolean isApplied;

    @Column
    Date appliedDate;

    @Column
    Date referedDate;

    public AppliedForRecruiterJob() {
    }

    public AppliedForRecruiterJob(CandidateProfile candidateProfile, RecruiterJobs recruiterJobs, User user, Boolean isSeen, Boolean isApplied, Date appliedDate, Date referedDate) {
        this.candidateProfile = candidateProfile;
        this.recruiterJobs = recruiterJobs;
        this.user = user;
        this.isSeen = isSeen;
        this.isApplied = isApplied;
        this.appliedDate = appliedDate;
        this.referedDate = referedDate;
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

    public RecruiterJobs getRecruiterJobs() {
        return recruiterJobs;
    }

    public void setRecruiterJobs(RecruiterJobs recruiterJobs) {
        this.recruiterJobs = recruiterJobs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getReferedDate() {
        return referedDate;
    }

    public void setReferedDate(Date referedDate) {
        this.referedDate = referedDate;
    }
}
