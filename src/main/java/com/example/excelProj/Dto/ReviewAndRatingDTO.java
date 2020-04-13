package com.example.excelProj.Dto;


import java.util.Date;

public class ReviewAndRatingDTO {


    String review;
    Integer rating;
    String ratedTo;
    Long jobId;
    String ratedBy;
    Date date;
    Long companyId;

    public ReviewAndRatingDTO(String review, Integer rating, String ratedTo, Long jobId, String ratedBy, Date date, Long companyId) {
        this.review = review;
        this.rating = rating;
        this.ratedTo = ratedTo;
        this.jobId = jobId;
        this.ratedBy = ratedBy;
        this.date = date;
        this.companyId = companyId;
    }

    public ReviewAndRatingDTO() {
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRatedTo() {
        return ratedTo;
    }

    public void setRatedTo(String ratedTo) {
        this.ratedTo = ratedTo;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
