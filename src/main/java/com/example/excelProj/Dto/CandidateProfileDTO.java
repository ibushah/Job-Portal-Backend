package com.example.excelProj.Dto;

import com.example.excelProj.Model.Job;

import javax.persistence.Column;
import java.util.List;

public class CandidateProfileDTO {

    Long id;
    String name;
    String email;
    String field;
    String presentationLetter;
    Long candidateForeignId;
    String imageContentType;
    String resumeContentType;



    byte[] cv;

    byte[] dp;

//    List<Job> jobList;


    public CandidateProfileDTO() {
    }


    public CandidateProfileDTO(Long id, String name, String email, String field, String presentationLetter, Long candidateForeignId, String imageContentType, String resumeContentType, byte[] cv, byte[] dp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.field = field;
        this.presentationLetter = presentationLetter;
        this.candidateForeignId = candidateForeignId;
        this.imageContentType = imageContentType;
        this.resumeContentType = resumeContentType;
        this.cv = cv;
        this.dp = dp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
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
}
