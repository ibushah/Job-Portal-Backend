package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.*;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewAndRatingService {

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    @Autowired
    CompanyProfileRepository companyProfileRepository;

    public ApiResponse getAverageRating(Long companyId){
        Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(companyId);
        if(companyProfile.isPresent()){
//            here get average rating
            Double averageRating = reviewAndRatingRepository.getAverageRatingByCompanyProfileId(companyId);
            return new ApiResponse(200,"Average rating",averageRating);
        }
        return  new ApiResponse(500,"Something went wrong",null);
    }

    public ApiResponse saveRatingAndReview(ReviewAndRatingDTO reviewAndRatingDTO){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        reviewAndRatingDTO.setCandidateId(user.getCandidateProfile().getId());
        String userType = user.getUserType();

        Optional<ReviewAndRating> reviewAndRatingObject = reviewAndRatingRepository.findByCandidateIdAndCompanyProfileId(reviewAndRatingDTO.getCandidateId(),reviewAndRatingDTO.getCompanyId());
        if(reviewAndRatingObject.isPresent()) {
            return new ApiResponse(HttpStatus.ALREADY_REPORTED.value(), "Already rated", reviewAndRatingObject.get().getRating());

        }
        else if(reviewAndRatingDTO.getRating()!=0 && reviewAndRatingDTO.getReview()!=null){
            ReviewAndRating reviewAndRating = new ReviewAndRating();
            reviewAndRating.setRating(reviewAndRatingDTO.getRating());
            reviewAndRating.setReview(reviewAndRatingDTO.getReview());
            reviewAndRating.setCandidateId(reviewAndRatingDTO.getCandidateId());
            reviewAndRating.setRateBy(userType);
            reviewAndRating.setDate(new Date());
            Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(reviewAndRatingDTO.getCompanyId());
            if(companyProfile.isPresent()){
                reviewAndRating.setCompanyProfile(companyProfile.get());
                reviewAndRatingRepository.save(reviewAndRating);
                return new ApiResponse(200, "Get successfull rated", reviewAndRating.getRating());
            }
        }



        return  new ApiResponse(500,"Something went wrong",null);

}


    public ApiResponse saveReviewAgainstCandidate(ReviewAndRatingDTO reviewAndRatingDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);

        reviewAndRatingDTO.setCompanyId(user.getCompanyProfile().getId());

        ReviewAndRating reviewAndRating = reviewAndRatingRepository.checkReviewStatus(reviewAndRatingDTO.getCandidateId(),reviewAndRatingDTO.getCompanyId(),user.getUserType());

        if(reviewAndRating==null){
            ReviewAndRating reviewAndRatingModel = new ReviewAndRating();
            reviewAndRatingModel.setDate(new Date());
            reviewAndRatingModel.setCandidateId(reviewAndRatingDTO.getCandidateId());
            reviewAndRatingModel.setCompanyProfile(user.getCompanyProfile());
            reviewAndRatingModel.setReview(reviewAndRatingDTO.getReview());
            reviewAndRatingModel.setRating(reviewAndRatingDTO.getRating());
            reviewAndRatingModel.setRateBy(user.getUserType());
            reviewAndRatingRepository.save(reviewAndRatingModel);

            return new ApiResponse(200,"SucesssFull",reviewAndRatingRepository.getAllCompaniesWithReviews(reviewAndRatingDTO.getCandidateId(),user.getUserType()),reviewAndRatingRepository.getAverageCandidateRating(reviewAndRatingDTO.getCandidateId(),user.getUserType()));
        }

        return  new ApiResponse(500,"Something went wrong",null);

    }




}

