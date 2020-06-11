package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDetailsDTO;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.ReviewAndRating;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.CompanyProfileRepository;
import com.example.excelProj.Repository.ReviewAndRatingRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyProfileService {


    @Autowired
    CompanyProfileRepository companyProfileRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;


    public ApiResponse<String> postCompanyProfile(Long userId, CompanyProfileDTO companyProfileDTO) {
        Optional<User> optionalUser = userDaoRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getProfileActive()) {
                user.setProfileActive(true);
                userDaoRepository.save(user);
            }
            CompanyProfile companyProfile = companyProfileRepository.findByUserId(userId) != null ? companyProfileRepository.findByUserId(userId) : new CompanyProfile();


            companyProfile.setBillingAddress(companyProfileDTO.getBillingAddress());
            companyProfile.setContactName(companyProfileDTO.getContactName());
            companyProfile.setContactTitle(companyProfileDTO.getContactTitle());
            companyProfile.setCorporateAddress(companyProfileDTO.getCorporateAddress());
            companyProfile.setLogo(companyProfileDTO.getLogo());
            companyProfile.setName(companyProfileDTO.getName());
            companyProfile.setLogoContentType(companyProfileDTO.getLogoContentType());
            companyProfile.setUser(user);
            if(user.getUserType().equalsIgnoreCase("recruiter")){
                companyProfile.setResume(companyProfileDTO.getResume());
                companyProfile.setCertificate(companyProfileDTO.getCertificate());
                companyProfile.setResumeContentType(companyProfileDTO.getResumeContentType());
                companyProfile.setCertificateContentType(companyProfileDTO.getCertificateContentType());
            }

            companyProfileRepository.save(companyProfile);
            return new ApiResponse(200, "Company profile successfuly updated", companyProfileRepository.findByUserId(userId));

        }

        return new ApiResponse(500, "Something went wrong", null);

    }


    public CompanyProfileDetailsDTO getCompanyProfile(Long companyId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        Optional<ReviewAndRating> reviewAndRatingObject = Optional.empty();



        if (user != null && user.getUserType().equalsIgnoreCase("candidate")){
            Long candidateId = user.getCandidateProfile().getId();
            reviewAndRatingObject = reviewAndRatingRepository.findByCandidateIdAndCompanyProfileIdAndAndRateBy(candidateId,companyId,"candidate");
        }



        CompanyProfileDetailsDTO companyProfileDetailsDTO = new CompanyProfileDetailsDTO();
        List<CompanyReviewRatingDTO> companyReviewRatingDTOList = companyProfileRepository.getByCompanyId(companyId,"candidate");
        Optional<CompanyProfile> optionalCompanyProfile = companyProfileRepository.findById(companyId);
        CompanyProfile companyProfile = optionalCompanyProfile!=null ? optionalCompanyProfile.get() : new CompanyProfile();
        if(reviewAndRatingObject.isPresent()){
                companyProfileDetailsDTO.setAlreadyCommented(true);
        }
        else{
            companyProfileDetailsDTO.setAlreadyCommented(false);
        }

        Double avgRating = reviewAndRatingRepository.getAverageRatingByCompanyProfileId(companyId,"candidate");
        companyProfileDetailsDTO.setCompanyReviewRatingDTOList(companyReviewRatingDTOList);
        companyProfileDetailsDTO.setCompanyProfile(companyProfile);
        companyProfileDetailsDTO.setAvgRating(avgRating);

        return companyProfileDetailsDTO;
    }


    public ApiResponse<CompanyProfile> findCompanybyUserId(Long userId){
        Optional<User> optionalUser = userDaoRepository.findById(userId);
        if(optionalUser.isPresent()){
            return new ApiResponse(200, "Company profile successfuly Get", companyProfileRepository.findByUserId(userId));

        }
        return new ApiResponse(500, "Something went wrong", null);
    }




}