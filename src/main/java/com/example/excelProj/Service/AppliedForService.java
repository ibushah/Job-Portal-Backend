package com.example.excelProj.Service;


import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.AppliedFor;
import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.AppliedForRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AppliedForService {

    @Autowired
    AppliedForRepository appliedForRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    JobRepository jobRepository;



    public String applyOnJob(ReviewAndRatingDTO reviewAndRatingDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);


        if (user != null && user.getUserType().equalsIgnoreCase("candidate") && user.getCandidateProfile() != null) {


            Optional<Job> job = jobRepository.findById(reviewAndRatingDTO.getJobId());
            CandidateProfile candidateProfile = user.getCandidateProfile();
            AppliedFor appliedForPresent=appliedForRepository.applied(job.get().getId(),candidateProfile.getId());
            if(appliedForPresent==null) {
                AppliedFor appliedFor = new AppliedFor(candidateProfile, job.get(), false, new Date());
                appliedForRepository.save(appliedFor);
                return "Applied on Job";
            }
            else {
                return "Error";
            }
        }
        return "Error";
    }


}
