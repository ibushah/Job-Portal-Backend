package com.example.excelProj.Service;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllCompaniesWithReviewDTO;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Dto.CandidateProfileWtihAllDetailsDTO;
import com.example.excelProj.Dto.UserProfilesDTO;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateProfileService {

    @Autowired
    UserDaoRepository userDaoRepository;
    @Autowired
    JobRepository jobRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;

    @Autowired
    AppliedForRepository appliedForRepository;

    @Autowired
    UserProfilesRepository userProfilesRepository;


    public ApiResponse getCandidateProfileComplete(Long userId,Long candidateId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User loggedInUser = userDaoRepository.findByEmail(currentPrincipalName);

//        First get candidateProfile
        Optional<User> user = userDaoRepository.findById(userId);
        candidateId = user.isPresent()?user.get().getCandidateProfile().getId():candidateId;
        CandidateProfile candidateProfile = candidateProfileRepository.findByUserId(userId);
        CandidateProfileWtihAllDetailsDTO candidateProfileWtihAllDetailsDTO = new CandidateProfileWtihAllDetailsDTO();


        if(candidateProfile!=null){
            candidateProfileWtihAllDetailsDTO.setCandidateProfile(candidateProfile);
            candidateProfileWtihAllDetailsDTO.setRating(reviewAndRatingRepository.getAverageCandidateRating(candidateId));
            List<AllCompaniesWithReviewDTO> companiesWithReviewDTOS = reviewAndRatingRepository.getAllCompaniesWithReviews(candidateId);
            candidateProfileWtihAllDetailsDTO.setCompaniesWithReviewDTOList(companiesWithReviewDTOS);


            if(!loggedInUser.getUserType().equalsIgnoreCase("candidate")){
                Long companyId  = loggedInUser.getCompanyProfile().getId();
                ReviewAndRating reviewAndRating = reviewAndRatingRepository.checkReviewStatus(candidateId,companyId,loggedInUser.getUserType());
                if(reviewAndRating!=null){

                    candidateProfileWtihAllDetailsDTO.setAlreadyGivenReview(true);
                }
                else{
                    candidateProfileWtihAllDetailsDTO.setAlreadyGivenReview(false);
                }
            }


         return  new ApiResponse(200,"Successfull",candidateProfileWtihAllDetailsDTO);
        }
        return new ApiResponse(500,"unsuccessfull",null);

    }



//review by employer and recuirter






    public ApiResponse postCandidateProfile(Long userId, UserProfilesDTO candidateProfileDTO)
    {
        Optional<User> optionalUser =userDaoRepository.findById(userId);

        if(optionalUser.isPresent())
        {
            User user=optionalUser.get();

            if(!user.getProfileActive())
                user.setProfileActive(true);

            user.setEmail(candidateProfileDTO.getEmail());
            user.setName(candidateProfileDTO.getName());
            userDaoRepository.save(user);
            User newUser=userDaoRepository.findById(userId).isPresent()?userDaoRepository.findById(userId).get():null;


            UserProfiles candidateProfile=userProfilesRepository.findByUserId(userId)!=null?userProfilesRepository.findByUserId(userId):new UserProfiles();
            candidateProfile.setPresentationLetter(candidateProfileDTO.getPresentationLetter());
            candidateProfile.setField(candidateProfileDTO.getField());
            candidateProfile.setResume(candidateProfileDTO.getResume());
            candidateProfile.setDp(candidateProfileDTO.getDp());
            candidateProfile.setResumeContentType(candidateProfileDTO.getResumeContentType());
            candidateProfile.setDpContentType(candidateProfileDTO.getDpContentType());
            candidateProfile.setUser(newUser);
            userProfilesRepository.save(candidateProfile);
            return new ApiResponse(200,"Candidate profile successfuly updated",userDaoRepository.findById(userId).get());
        }

        return  new ApiResponse(500,"Something went wrong",null);


    }


    public User saveUser(User user)
    {
        return userDaoRepository.save(user);
    }



    public ApiResponse getAlreadyAppliedJobs(Long candidateId,Long jobId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        boolean isApplied = false;


        if (user != null && user.getUserType().equalsIgnoreCase("candidate")) {

            Optional<CandidateProfile> candidateProfile = candidateProfileRepository.findById(user.getCandidateProfile().getId());
            Optional<Job> job=jobRepository.findById(jobId);
            if(candidateProfile.isPresent() && job.isPresent()){

               AppliedFor appliedFor= appliedForRepository.applied(job.get().getId(),candidateProfile.get().getId());
               if(appliedFor!=null)
               {
                   return  new ApiResponse(200,"Already appied",true);
               }

                return  new ApiResponse(500,"Not applied on job",false);
            }

        }
        return  new ApiResponse(500,"Something went wrong",false);



    }

    public ApiResponse  getCandidateProfile(Long userId){
        Optional<User> user = userDaoRepository.findById(userId);
        if(user.isPresent()){
            UserProfiles candidateProfile = userProfilesRepository.findByUserId(userId);
                return new ApiResponse(200,"Successfully",candidateProfile);
        }
        return new ApiResponse(500,"Unsuccessfull",null);
    }
}