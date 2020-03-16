package com.example.excelProj.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CandidateProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String field;
    String presentationLetter;
    Long candidateForeignId;


    @ManyToMany(mappedBy = "candidateProfileList")
    List<Job> jobList;


    public CandidateProfile() {
    }

    public CandidateProfile(String field, String presentationLetter, Long candidateForeignId) {
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
