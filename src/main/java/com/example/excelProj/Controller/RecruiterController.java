package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.RecruiterJobsDTO;
import com.example.excelProj.Dto.ReferJobToCandidateDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.RecruiterJobs;
import com.example.excelProj.Repository.AppliedForRecruiterJobRepository;
import com.example.excelProj.Repository.RecruiterJobRepository;
import com.example.excelProj.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Rehan on 5/28/2020.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/recruiter/")
public class RecruiterController {




    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    RecruiterService recruiterService;


    @Autowired
    AppliedForRecruiterJobRepository appliedForRecruiterJobRepository;



    @PostMapping("post/job")
    public ApiResponse postRecruiterJob(@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.postJob(recruiterProfileDTO);
    }

    @PutMapping("update/job/{jobId}")
    public ApiResponse updateRecruiterJob(@PathVariable("jobId") Long jobId,@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.updateJob(jobId,recruiterProfileDTO);
    }

    @GetMapping("get/job/{companyId}")
    public Page<RecruiterJobs> getAllJobsOfRecruiterUserId(@PathVariable("companyId") Long companyId, @RequestParam(defaultValue = "0")int page){

        org.springframework.data.domain.Pageable pageable = PageRequest.of(page,5);

         return  recruiterJobRepository.findAllJobsByRecruiterCompanyId(companyId,pageable);
    }

    @GetMapping("get/{jobId}")
    public ApiResponse getJobByJobId(@PathVariable("jobId") Long jobId){

        return  new ApiResponse(200,"Successfull",recruiterJobRepository.findById(jobId));
    }


    @PostMapping("referJobToCandidate")
    public ApiResponse referRecruiterJobToCandidates(@RequestBody ReferJobToCandidateDTO referJobToCandidateDTO){
//        Long userId = Long.parseLong(requestParam.get("userId"));
//        Long jobId  = Long.parseLong(requestParam.get("jobId"));
//        Long candidateId = Long.parseLong(requestParam.get("candidateId"));

        return recruiterService.referJob(referJobToCandidateDTO);

    }


    @GetMapping("jobsbycategory")
    public Page<RecruiterJobs> getJobsByCategory(@RequestParam Map<String,String> requestParams){
        String category=requestParams.get("category");
        category = category.replaceAll("_and_","&");
        Integer page=Integer.parseInt(requestParams.get("page"));

        Pageable pageable = PageRequest.of(page,5);

        return recruiterJobRepository.findByCategory(category,pageable);
    }


    @GetMapping("privateJobAllDetails/{jobId}")
    public ApiResponse getAllInfoAgainstASingleJob(@PathVariable("jobId") Long jobId){
        return recruiterService.getAllInfoOfJobIdForRecruiter(jobId);
//        return  appliedForRecruiterJobRepository.getAllByCandidateProfile(jobId);
    }



    @GetMapping("privateJobDetailForCandidate/{jobId}")
    public ApiResponse detailsForCandidate(@PathVariable("jobId") Long jobId){
        return recruiterService.privateJobDetailsForCandidate(jobId);
    }


    @PostMapping("apply")
    public ApiResponse applyOnPrivateJob(@RequestBody ReferJobToCandidateDTO referJobToCandidateDTO){
        return recruiterService.applyOnJobByCandidate(referJobToCandidateDTO);
    }


    @DeleteMapping("delete/{jobId}/page")
    public ApiResponse deleteJobAndItsAssociations(@PathVariable(name = "jobId") Long jobId,@RequestParam(name = "page") int page){
        return  recruiterService.deleteJobById(jobId,PageRequest.of(page,5));
    }


    @GetMapping("search")
    public ApiResponse searchAllCandidates(@RequestParam("search") String searchString){

        return  recruiterService.searchAllCandidates(searchString);
    }





}


