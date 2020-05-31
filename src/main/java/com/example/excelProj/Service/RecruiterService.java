package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.*;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Rehan on 5/28/2020.
 */

@Service

public class RecruiterService {



    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;
    @Autowired
    AppliedForRecruiterJobRepository appliedForRecruiterJobRepository;
    @Autowired
    CandidateProfileRepository candidateProfileRepository;


    @Autowired
    CompanyProfileRepository companyProfileRepository;


    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;





    public ApiResponse postJob(RecruiterJobsDTO jobDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);

        if (user != null && user.getUserType().equalsIgnoreCase("recruiter")) {

            RecruiterJobs job = new RecruiterJobs();
            job.setDescription(jobDTO.getDescription());
            job.setSalary(jobDTO.getSalary());
            job.setLatitude(jobDTO.getLatitude());
            job.setLongitude(jobDTO.getLongitude());
            job.setTitle(jobDTO.getTitle());
            job.setCity(jobDTO.getCity());
            job.setCountry(jobDTO.getCountry());
            job.setProvince(jobDTO.getProvince());
            job.setCategory(jobDTO.getCategory());
            job.setType(jobDTO.getType());
            job.setPublishFrom(jobDTO.getPublishFrom());
            job.setAddress(jobDTO.getAddress());
            job.setPublishTo(jobDTO.getPublishTo());
            job.setCompanyProfileJobs(user.getCompanyProfile());
            job.setDate(new Date());
            return new ApiResponse(200, "Recruiter Job successfully posted", recruiterJobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }


    public ApiResponse updateJob(Long jobId,RecruiterJobsDTO jobDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);

        if (user != null && user.getUserType().equalsIgnoreCase("recruiter") && user.getCompanyProfile()!=null) {

            RecruiterJobs job = new RecruiterJobs();
            job.setDescription(jobDTO.getDescription());
            job.setSalary(jobDTO.getSalary());
            job.setLatitude(jobDTO.getLatitude());
            job.setLongitude(jobDTO.getLongitude());
            job.setTitle(jobDTO.getTitle());
            job.setCity(jobDTO.getCity());
            job.setCountry(jobDTO.getCountry());
            job.setProvince(jobDTO.getProvince());
            job.setCategory(jobDTO.getCategory());
            job.setType(jobDTO.getType());
            job.setPublishFrom(jobDTO.getPublishFrom());
            job.setAddress(jobDTO.getAddress());
            job.setPublishTo(jobDTO.getPublishTo());
            job.setCompanyProfileJobs(user.getCompanyProfile());
            job.setDate(new Date());
            return new ApiResponse(200, "Recruiter Job successfully updated", recruiterJobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }




    public ApiResponse referJob(ReferJobToCandidateDTO referJobToCandidateDTO){

//        check all these three things exits or not

        Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(referJobToCandidateDTO.getCompanyId());
        Optional<RecruiterJobs> recruiterJobs = recruiterJobRepository.findById(referJobToCandidateDTO.getJobId());

        if(companyProfile.isPresent() && recruiterJobs.isPresent()){
            AppliedForRecruiterJob appliedForRecruiterJob = new AppliedForRecruiterJob();

            for (Long candidateIds:referJobToCandidateDTO.getCandidateProfilesIds()) {
                appliedForRecruiterJob.setCompanyProfile(companyProfile.get());
                appliedForRecruiterJob.setRecruiterJobs(recruiterJobs.get());
                appliedForRecruiterJob.setCandidateProfile(candidateProfileRepository.findById(candidateIds).get());
                appliedForRecruiterJob.setSeen(false);
                appliedForRecruiterJob.setApplied(false);
                appliedForRecruiterJob.setAppliedDate(null);
                appliedForRecruiterJob.setReferedDate(new Date());
                appliedForRecruiterJobRepository.save(appliedForRecruiterJob);
            }

            return new ApiResponse(200,"SuccessFully refered",appliedForRecruiterJob);
        }
        return  new ApiResponse(500,"ERROR OCCURED",null);

    }


}