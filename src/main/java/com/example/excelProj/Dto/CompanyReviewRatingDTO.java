package com.example.excelProj.Dto;

import java.io.Serializable;
import java.util.Date;

public class CompanyReviewRatingDTO implements Serializable {

    Long id;
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
    String type;
    String videoUrl;



    public CompanyReviewRatingDTO() {
    }

//    public CompanyReviewRatingDTO(Long userId, Long candidateId, String name, String email, Integer rating, String review, byte[] cv, byte[] dp, String field, String imageContentType, String resumeContentType, Date date) {
//        this.userId = userId;
//        this.candidateId = candidateId;
//        this.name = name;
//        this.email = email;
//        this.rating = rating;
//        this.review = review;
//        this.cv = cv;
//        this.dp = dp;
//        this.field = field;
//        this.imageContentType = imageContentType;
//        this.resumeContentType = resumeContentType;
//        this.date = date;
//    }


    public CompanyReviewRatingDTO(Long id, Long userId, Long candidateId, String name, String email, Integer rating, String review, byte[] cv, byte[] dp, String field, String imageContentType, String resumeContentType, Date date, String type, String videoUrl) {
        this.id = id;
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
        this.type = type;
        this.videoUrl = videoUrl;
    }

    public CompanyReviewRatingDTO(Long userId, Long candidateId, String name, String email, Integer rating, String review, byte[] cv, byte[] dp, String field, String imageContentType, String resumeContentType, Date date, String type, String videoUrl) {
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
        this.type = type;
        this.videoUrl = videoUrl;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

