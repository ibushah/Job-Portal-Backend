package com.example.excelProj.Dto;

import com.example.excelProj.Model.CompanyProfile;

import java.util.List;

public class CompanyProfileDetailsDTO {

    Double avgRating;
    CompanyProfile companyProfile;
    List<CompanyReviewRatingDTO> companyReviewRatingDTOList;

    public CompanyProfileDetailsDTO(Double avgRating, CompanyProfile companyProfile, List<CompanyReviewRatingDTO> companyReviewRatingDTOList) {
        this.avgRating = avgRating;
        this.companyProfile = companyProfile;
        this.companyReviewRatingDTOList = companyReviewRatingDTOList;
    }


    public CompanyProfileDetailsDTO() {
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
}
