package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllJobsDTO;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    JobPaginationRepository jobPaginationRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;


    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;


    @Autowired
    CompanyProfileRepository companyProfileRepository;
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

//    Paginated jobs


    public Page<Job> getPaginatedJobs(int pageNumber){
        Pageable firstPageWithTenElements = PageRequest.of(pageNumber, 10);
        return jobPaginationRepository.findAll(firstPageWithTenElements);
    }


    public ApiResponse getAJob(Long id) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {
            return new ApiResponse(200, "Job fetching successful", optionalJob.get());
        }
        return new ApiResponse(500, "Error fetching the job", null);
    }

//    public List<Job> searchJobByField(String field){
//        if(field.equalsIgnoreCase("all"))
//            return jobRepository.findAll();
//        else{
//            return jobRepository.findByField(field);
//        }
//
//    }

    public ApiResponse postJob(JobDTO jobDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);


        if (user != null && user.getUserType().equalsIgnoreCase("employee") && user.getCompanyProfile() != null) {

            Job job = new Job();

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
            job.setPublishTo(jobDTO.getPublishTo());
            job.setCompanyProfile(user.getCompanyProfile());
            return new ApiResponse(200, "Job successfully posted", jobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }


    public ApiResponse<Job> apply_on_job(ReviewAndRatingDTO reviewAndRatingDTO){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);
        if (user != null && user.getUserType().equalsIgnoreCase("candidate") && user.getCandidateProfile()!=null){

                Optional<Job> job = jobRepository.findById(reviewAndRatingDTO.getJobId());
                CandidateProfile candidateProfile = user.getCandidateProfile();
                    reviewAndRatingDTO.setCandidateId(user.getCandidateProfile().getId());

               if(job.isPresent())
               {
                   List<CandidateProfile> candidateProfiles = job.get().getCandidateProfileList();
                   candidateProfiles.add(candidateProfile);
                   job.get().setCandidateProfileList(candidateProfiles);
                   if(reviewAndRatingDTO.getRating()!=0 && reviewAndRatingDTO.getReview()!=null){


                       if(saveRatingAndReview(reviewAndRatingDTO)){
                           return new ApiResponse(200, "Job successfully posted", jobRepository.save(job.get()));
                       }

                   }
                   else{
                       return new ApiResponse(200, "Job successfully posted", jobRepository.save(job.get()));
                   }
               }

               }
                return new ApiResponse(500, "Something went wrong", null);

        }





    public ApiResponse<Job> getMyJobs(Long employeeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);

        if (user != null && user.getUserType().equalsIgnoreCase("employee") && user.getCompanyProfile() != null) {

                List<Job> jobList = jobRepository.findByEmployeeId(employeeId);
                return  new ApiResponse(200,"Successfull",jobList);

        }
        else{
            return new ApiResponse(500, "Something went wrong", null);
        }
    }

    public  List<Job> getJobsByCompany(Long id){

       Optional<Job> job=jobRepository.findById(id);
        if(job.isPresent())
        {
            return jobRepository.findByCompanyId(job.get().getCompanyProfile().getId());
        }
        return null;

    }


    public Boolean saveRatingAndReview(ReviewAndRatingDTO reviewAndRatingDTO){

        ReviewAndRating reviewAndRating = new ReviewAndRating();
        reviewAndRating.setRating(reviewAndRatingDTO.getRating());
        reviewAndRating.setReview(reviewAndRatingDTO.getReview());
        reviewAndRating.setCandidateId(reviewAndRatingDTO.getCandidateId());
        Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(reviewAndRatingDTO.getCompanyId());
        if(companyProfile.isPresent()){
            reviewAndRating.setCompanyProfile(companyProfile.get());
            reviewAndRatingRepository.save(reviewAndRating);
            return  true;
        }
        return  false;

    }

    public ApiResponse getAppliedCandidateByJobId(Long jobId){
        Optional<Job> job = jobRepository.findById(jobId);
        Integer count = 0;
        if(job.isPresent()){

           count  = jobRepository.countOfCandidates(jobId);
            count = count!=0?count:0;
            return new ApiResponse(200,"succesfull",count);

        }
        else{
            return new ApiResponse(500,"unsuccessfull",count);

        }
    }

    public ApiResponse getAppliedCandidateProfilesByJobId(Long jobId){
        Optional<Job> job = jobRepository.findById(jobId);
        List<CandidateProfile> candidateProfiles = new ArrayList<>();
        if(job.isPresent()){
            List<Long> idList = jobRepository.findAllCandidateProfile(jobId);
            for (Long candidateId:idList) {
                Optional<CandidateProfile> candidateProfileOptional = candidateProfileRepository.findById(candidateId);

                    if(candidateProfileOptional.isPresent()){
                        CandidateProfile candidateProfile = candidateProfileOptional.get();
                        candidateProfiles.add(candidateProfile);
                    }
            }
            return new ApiResponse(200,"succesfull",candidateProfiles);

            }
        return new ApiResponse(500,"unsuccessfull",null);
    }

}

