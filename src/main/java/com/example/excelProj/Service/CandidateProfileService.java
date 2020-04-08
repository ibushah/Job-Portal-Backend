package com.example.excelProj.Service;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
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

    public ApiResponse postCandidateProfile(Long userId, CandidateProfileDTO candidateProfileDTO)
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


            CandidateProfile candidateProfile=candidateProfileRepository.findByUserId(userId)!=null?candidateProfileRepository.findByUserId(userId):new CandidateProfile();
            candidateProfile.setPresentationLetter(candidateProfileDTO.getPresentationLetter());
            candidateProfile.setField(candidateProfileDTO.getField());
            candidateProfile.setCv(candidateProfileDTO.getCv());
            candidateProfile.setDp(candidateProfileDTO.getDp());
            candidateProfile.setResumeContentType(candidateProfileDTO.getResumeContentType());
            candidateProfile.setImageContentType(candidateProfileDTO.getImageContentType());
            candidateProfile.setUser(newUser);
            candidateProfileRepository.save(candidateProfile);
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
            if(candidateProfile.isPresent()){

                List<Job> jobList = candidateProfile.get().getJobList();
                if(!jobList.isEmpty()){
                    for (Job job : jobList) {
                        if (job.getId() == jobId){
                            isApplied = true;
                            return new ApiResponse(200,"Applied Jobs against User Successfull",isApplied);
                        }
                    }

                }
            }

        }
        return  new ApiResponse(500,"Something went wrong",isApplied);




    }

    public ApiResponse getCandidateProfile(Long userId){
        Optional<User> user = userDaoRepository.findById(userId);
        if(user.isPresent()){
            CandidateProfile candidateProfile = candidateProfileRepository.findByUserId(userId);
            return new ApiResponse(200,"Successfully",candidateProfile);
        }
        return new ApiResponse(500,"Unsuccessfull",null);
    }
}

