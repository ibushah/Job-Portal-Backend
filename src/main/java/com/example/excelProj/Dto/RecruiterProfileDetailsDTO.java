package com.example.excelProj.Dto;

import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.RecruiterProfile;
import com.example.excelProj.Model.User;

import java.util.List;

/**
 * Created by Rehan on 5/30/2020.
 */
public class RecruiterProfileDetailsDTO {
    User userProfile;

//    companyReviewAndRating DTO is same for recruiterProfile details for all ratings and reviews given by candidate
//    thats why we dont need another DTO

    List<CompanyReviewRatingDTO> companyReviewRatingDTOList;
    Boolean alreadyCommented;


    public User getUserProfile() {
        return userProfile;
    }

    public RecruiterProfileDetailsDTO() {
    }

    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }

    public RecruiterProfileDetailsDTO(User userProfile, List<CompanyReviewRatingDTO> companyReviewRatingDTOList, Boolean alreadyCommented) {
        this.userProfile = userProfile;
        this.companyReviewRatingDTOList = companyReviewRatingDTOList;
        this.alreadyCommented = alreadyCommented;
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
