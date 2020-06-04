package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.*;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sun.security.acl.AllPermissionsImpl;

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
    NotificationsRepository notificationsRepository;

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
            job.companyProfile(user.getCompanyProfile());
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
            job.companyProfile
                    (user.getCompanyProfile());
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
                appliedForRecruiterJob.setCompanyProfile(companyProfile.get());
                appliedForRecruiterJob.setRecruiterJobs(recruiterJobs.get());
                appliedForRecruiterJob.setCandidateProfile(candidateProfileRepository.findById(referJobToCandidateDTO.getCandidateId()).get());
                appliedForRecruiterJob.setSeenOrNot(false);
                appliedForRecruiterJob.setApplied(false);
                appliedForRecruiterJob.setAppliedDate(null);
                appliedForRecruiterJob.setReferedDate(new Date());
                appliedForRecruiterJobRepository.save(appliedForRecruiterJob);


            return new ApiResponse(200,"SuccessFully refered",true);
        }
        return  new ApiResponse(500,"ERROR OCCURED",null);

    }



    public ApiResponse getAllInfoOfJobIdForRecruiter(Long jobId){


        ViewPrivateJobDTO viewPrivateJobDTO = new ViewPrivateJobDTO();
        Optional<RecruiterJobs> recruiterJobs = recruiterJobRepository.findById(jobId);
        viewPrivateJobDTO.setRecruiterJobs(recruiterJobs.get());
        List<AllCandidatesReferedOrNotList> allCandidatesReferedOrNotLists = appliedForRecruiterJobRepository.getAllCandidates(jobId);
        viewPrivateJobDTO.setAllCandidatesReferedOrNotList(allCandidatesReferedOrNotLists);
        return new ApiResponse(200,"SUCCESSFULL",viewPrivateJobDTO);

    }




    public ApiResponse privateJobDetailsForCandidate(Long jobId){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        ViewPrivateJobDTO viewPrivateJobDTO = new ViewPrivateJobDTO();

        if(user.getUserType().equalsIgnoreCase("candidate")){
            Optional<RecruiterJobs> recruiterJobs = recruiterJobRepository.findById(jobId);
            Long companyId = recruiterJobs.get().companyProfile().getId();
            Long candiateId = user.getCandidateProfile().getId();

            viewPrivateJobDTO.setRecruiterJobs(recruiterJobs.get());
            viewPrivateJobDTO.setCandidateProfiles(null);
            viewPrivateJobDTO.setAllCandidatesReferedOrNotList(null);

           Optional<AppliedForRecruiterJob> appliedForRecruiterJob =  appliedForRecruiterJobRepository.findByCandidateProfileIdAndCompanyProfileIdAndRecruiterJobsIdAndIsApplied(candiateId,companyId,jobId,true);
            if(appliedForRecruiterJob.isPresent()){
                return new ApiResponse(200,"Successfull",viewPrivateJobDTO,null,true);
            }
            return new ApiResponse(200,"Successfull",viewPrivateJobDTO,null,false);


        }

        return  null;
    }

    public ApiResponse applyOnJobByCandidate(ReferJobToCandidateDTO referJobToCandidateDTO){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);
        Long candId = user.getCandidateProfile().getId();
        AppliedForRecruiterJob  appliedForRecruiterJob = appliedForRecruiterJobRepository.applyOnJob(candId,referJobToCandidateDTO.getCompanyId(),referJobToCandidateDTO.getJobId());
        if(appliedForRecruiterJob!=null){


            appliedForRecruiterJob.setApplied(true);
            appliedForRecruiterJob.setAppliedDate(new Date());
            appliedForRecruiterJobRepository.save(appliedForRecruiterJob);

//            Notifications notifications = new Notifications();
//            notifications.setCandidateId(candId);
//            notifications.setCompanyId(referJobToCandidateDTO.getCompanyId());
//            notifications.setJobId(referJobToCandidateDTO.getJobId());
//            notifications.setNotificateFor("candidate");
//            notifications.setNotificationDate(new Date());
//            notifications.setSeenOrNot(false);
//            notifications.setTypeOfJob("private");
//            notificationsRepository.save(notifications);


            return new ApiResponse(200,"Successfull",appliedForRecruiterJob);
        }
        else {
            return  new ApiResponse(500,"Unsuccessfull",null);
        }
    }


    public ApiResponse deleteJobById(Long id,Pageable pageable){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        if(user!=null) {

            Boolean jobExist = recruiterJobRepository.existsById(id);
            //first delete a job than then its association
            if (jobExist) {
                recruiterJobRepository.deleteById(id);
                //now delete its associations in the applied for table
                appliedForRecruiterJobRepository.deleteAssociatedRecords(id);
                return new ApiResponse(200, "Deleted", recruiterJobRepository.findAllJobsByRecruiterCompanyId(user.getCompanyProfile().getId(),pageable));
            }

        }
        return new ApiResponse(500,"unsuccessfull",null);
    }



        public ApiResponse searchAllCandidates(String search){
            List<CandidateProfile> candidateProfiles = candidateProfileRepository.search(search);
            return new ApiResponse(200,"Successfull",candidateProfiles);
        }

}