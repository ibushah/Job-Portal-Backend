package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.List;

/**
 * Created by Rehan on 4/14/2020.
 */
public class CandidateProfileWtihAllDetailsDTO {

    CandidateProfile candidateProfile;
    List<AllCompaniesWithReviewDTO> companiesWithReviewDTOList;
    Boolean isAlreadyGivenReview;


    public CandidateProfileWtihAllDetailsDTO() {
    }

    public CandidateProfileWtihAllDetailsDTO(CandidateProfile candidateProfile, List<AllCompaniesWithReviewDTO> companiesWithReviewDTOList, Boolean isAlreadyGivenReview) {
        this.candidateProfile = candidateProfile;
        this.companiesWithReviewDTOList = companiesWithReviewDTOList;
        this.isAlreadyGivenReview = isAlreadyGivenReview;
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
