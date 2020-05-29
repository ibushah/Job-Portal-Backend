package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Dto.RecruiterJobsDTO;
import com.example.excelProj.Dto.RecruiterProfileDTO;
import com.example.excelProj.Dto.ReferJobToCandidateDTO;
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
    RecruiterRepository recruiterRepository;

    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;
    @Autowired
    AppliedForRecruiterJobRepository appliedForRecruiterJobRepository;
    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    public ApiResponse saveRecruiterProfile(Long userId, RecruiterProfileDTO recruiterProfileDTO) {
        Optional<User> optionalUser = userDaoRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (!user.getProfileActive()) {
                user.setProfileActive(true);
                userDaoRepository.save(user);
            }
            RecruiterProfile recruiterProfile = recruiterRepository.findByUserId(userId) != null ? recruiterRepository.findByUserId(userId) : new RecruiterProfile();

            recruiterProfile.setName(recruiterProfileDTO.getName());
            recruiterProfile.setBillingAddress(recruiterProfileDTO.getBillingAddress());
            recruiterProfile.setCertificate(recruiterProfileDTO.getCertificate());
            recruiterProfile.setCertificateContentType(recruiterProfileDTO.getCertificateContentType());
            recruiterProfile.setResume(recruiterProfileDTO.getResume());
            recruiterProfile.setResumeContentType(recruiterProfileDTO.getResumeContentType());
            recruiterProfile.setBillingAddress(recruiterProfileDTO.getBillingAddress());
            recruiterProfile.setCorporateAddress(recruiterProfileDTO.getCorporateAddress());
            recruiterProfile.setContactName(recruiterProfileDTO.getContactName());
            recruiterProfile.setLogo(recruiterProfileDTO.getLogo());
            recruiterProfile.setLogoContentType(recruiterProfileDTO.getLogoContentType());
            recruiterProfile.setUser(user);
            recruiterRepository.save(recruiterProfile);
            return new ApiResponse(200, "ADDEDD SUCCESSFULLY", recruiterProfile);
        }
        return new ApiResponse(500, "USER NOT PRESENT", null);
    }






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
            job.setUser(user);
            job.setDate(new Date());
            return new ApiResponse(200, "Recruiter Job successfully posted", recruiterJobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }


    public ApiResponse updateJob(Long jobId,RecruiterJobsDTO jobDTO) {

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
            job.setUser(user);
            job.setDate(new Date());
            return new ApiResponse(200, "Recruiter Job successfully updated", recruiterJobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }




    public ApiResponse referJob(ReferJobToCandidateDTO referJobToCandidateDTO){

//        check all these three things exits or not

        Optional<User> user = userDaoRepository.findById(referJobToCandidateDTO.getUserId());
        Optional<RecruiterJobs> recruiterJobs = recruiterJobRepository.findById(referJobToCandidateDTO.getJobId());

        if(user.isPresent() && recruiterJobs.isPresent()){
            AppliedForRecruiterJob appliedForRecruiterJob = new AppliedForRecruiterJob();

            for (Long candidateIds:referJobToCandidateDTO.getCandidateProfilesIds()) {
                appliedForRecruiterJob.setUser(user.get());
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