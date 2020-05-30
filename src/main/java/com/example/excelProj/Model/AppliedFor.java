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
    private User appliedBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User poster;

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


    public AppliedFor(User appliedBy, User poster, Job job, Boolean isNotified, Date appliedDate) {
        this.appliedBy = appliedBy;
        this.poster = poster;
        this.job = job;
        this.isNotified = isNotified;
        this.appliedDate = appliedDate;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public User getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(User appliedBy) {
        this.appliedBy = appliedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
