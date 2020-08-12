package com.example.excelProj.Dto;

import com.example.excelProj.Model.CompanyProfile;

import java.util.List;

public class CompanyProfileDetailsDTO {

    Double avgRating;
    CompanyProfile companyProfile;
    List<CompanyReviewRatingDTO> companyReviewRatingDTOList;
    Boolean alreadyCommented;
    Long userId;

    public CompanyProfileDetailsDTO(Double avgRating, CompanyProfile companyProfile, List<CompanyReviewRatingDTO> companyReviewRatingDTOList, Boolean alreadyCommented) {
        this.avgRating = avgRating;
        this.companyProfile = companyProfile;
        this.companyReviewRatingDTOList = companyReviewRatingDTOList;
        this.alreadyCommented = alreadyCommented;
    }

    public CompanyProfileDetailsDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

    public List<CompanyReviewRatingDTO> getCompanyReviewRatingDTOList() {
        return companyReviewRatingDTOList;
    }

    public void setCompanyReviewRatingDTOList(List<CompanyReviewRatingDTO> companyReviewRatingDTOList) {
        this.companyReviewRatingDTOList = companyReviewRatingDTOList;
    }

    public Boolean getAlreadyCommented() {
        return alreadyCommented;
    }

    public void setAlreadyCommented(Boolean alreadyCommented) {
        this.alreadyCommented = alreadyCommented;
    }
}
