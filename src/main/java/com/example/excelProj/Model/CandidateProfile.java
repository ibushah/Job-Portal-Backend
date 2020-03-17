package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CandidateProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String field;

    @Column
    String presentationLetter;

    @Lob
    @Column
    byte[] cv;


    @Lob
    @Column
    byte[] dp;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
     User user;



    @ManyToMany(mappedBy = "candidateProfileList")
    List<Job> jobList;


    public CandidateProfile() {
    }

    public CandidateProfile(String field, String presentationLetter, byte[] cv, byte[] dp) {
        this.field = field;
        this.presentationLetter = presentationLetter;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
