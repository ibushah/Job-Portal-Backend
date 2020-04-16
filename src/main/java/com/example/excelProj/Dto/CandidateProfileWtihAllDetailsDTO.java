package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.List;

/**
 * Created by Rehan on 4/14/2020.
 */
public class CandidateProfileWtihAllDetailsDTO {

    Double rating;
    CandidateProfile candidateProfile;
    List<AllCompaniesWithReviewDTO> companiesWithReviewDTOList;
    Boolean isAlreadyGivenReview;


    public CandidateProfileWtihAllDetailsDTO() {
    }

    public CandidateProfileWtihAllDetailsDTO(Double rating, CandidateProfile candidateProfile, List<AllCompaniesWithReviewDTO> companiesWithReviewDTOList, Boolean isAlreadyGivenReview) {
        this.rating = rating;
        this.candidateProfile = candidateProfile;
        this.companiesWithReviewDTOList = companiesWithReviewDTOList;
        this.isAlreadyGivenReview = isAlreadyGivenReview;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public CandidateProfile getCandidateProfile() {
        return candidateProfile;
    }

    public void setCandidateProfile(CandidateProfile candidateProfile) {
        this.candidateProfile = candidateProfile;
    }

    public List<AllCompaniesWithReviewDTO> getCompaniesWithReviewDTOList() {
        return companiesWithReviewDTOList;
    }

    public void setCompaniesWithReviewDTOList(List<AllCompaniesWithReviewDTO> companiesWithReviewDTOList) {
        this.companiesWithReviewDTOList = companiesWithReviewDTOList;
    }

    public Boolean getAlreadyGivenReview() {
        return isAlreadyGivenReview;
    }

    public void setAlreadyGivenReview(Boolean alreadyGivenReview) {
        isAlreadyGivenReview = alreadyGivenReview;
    }
}
