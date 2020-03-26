package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.Job;

import java.util.List;

/**
 * Created by Rehan on 3/26/2020.
 */
public class ApplyJobDTO {

    String review;
    Integer rating;
    Long jobId;
    Long candidateId;

    public ApplyJobDTO(String review, Integer rating, Long jobId, Long candidateId) {
        this.review = review;
        this.rating = rating;
        this.jobId = jobId;
        this.candidateId = candidateId;
    }

    public ApplyJobDTO() {
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
