package com.example.excelProj.Dto;


public class ReviewAndRatingDTO {


    String review;
    Integer rating;
    Long candidateId;
    Long jobId;
    Long companyId;

    public ReviewAndRatingDTO() {
    }

    public ReviewAndRatingDTO(String review, Integer rating, Long candidateId, Long jobId, Long companyId) {
        this.review = review;
        this.rating = rating;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.companyId = companyId;
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

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
