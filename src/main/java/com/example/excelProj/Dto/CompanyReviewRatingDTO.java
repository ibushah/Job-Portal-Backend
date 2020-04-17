package com.example.excelProj.Dto;

import java.io.Serializable;
import java.util.Date;

public class CompanyReviewRatingDTO implements Serializable {

    Long userId;
    Long candidateId;
    String name;
    String email;
    Integer rating;
    String review;
    byte[] cv;
    byte[] dp;
    String field;
    String imageContentType;
    String resumeContentType;
    Date date;


    public CompanyReviewRatingDTO() {
    }

    public CompanyReviewRatingDTO(Long userId, Long candidateId, String name, String email, Integer rating, String review, byte[] cv, byte[] dp, String field, String imageContentType, String resumeContentType, Date date) {
        this.userId = userId;
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.review = review;
        this.cv = cv;
        this.dp = dp;
        this.field = field;
        this.imageContentType = imageContentType;
        this.resumeContentType = resumeContentType;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

