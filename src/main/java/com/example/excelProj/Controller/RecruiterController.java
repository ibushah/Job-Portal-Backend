package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.RecruiterJobsDTO;
import com.example.excelProj.Dto.RecruiterProfileDTO;
import com.example.excelProj.Dto.ReferJobToCandidateDTO;
import com.example.excelProj.Model.RecruiterProfile;
import com.example.excelProj.Repository.RecruiterJobRepository;
import com.example.excelProj.Repository.RecruiterRepository;
import com.example.excelProj.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Map;

/**
 * Created by Rehan on 5/28/2020.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/recruiter/")
public class RecruiterController {


    @Autowired
    RecruiterRepository recruiterRepository;

    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    RecruiterService recruiterService;


    @PostMapping("post/{userId}")
    public ApiResponse postRecruiterProfile(@PathVariable("userId") Long userId,@RequestBody RecruiterProfileDTO recruiterProfileDTO){
        return recruiterService.saveRecruiterProfile(userId,recruiterProfileDTO);
    }

    @PostMapping("post/job")
    public ApiResponse postRecruiterJob(@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.postJob(recruiterProfileDTO);
    }

    @PutMapping("update/job/{jobId}")
    public ApiResponse updateRecruiterJob(@PathVariable("jobId") Long jobId,@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.updateJob(jobId,recruiterProfileDTO);
    }

    @GetMapping("get/job/{userId}")
    public ApiResponse getAllJobsOfRecruiterUserId(@PathVariable("userId") Long userId,@RequestParam(defaultValue = "0")int page){

        org.springframework.data.domain.Pageable pageable = PageRequest.of(page,5);

         return  new ApiResponse(200,"Successfull",recruiterJobRepository.findAllJobsByRecruiterUserId(userId,pageable));
    }

    @GetMapping("get/{jobId}")
    public ApiResponse getJobByJobId(@PathVariable("userId") Long jobId){

        return  new ApiResponse(200,"Successfull",recruiterJobRepository.findById(jobId));
    }


    @PostMapping("referJobToCandidate")
    public ApiResponse referRecruiterJobToCandidates(@RequestBody ReferJobToCandidateDTO referJobToCandidateDTO){
//        Long userId = Long.parseLong(requestParam.get("userId"));
//        Long jobId  = Long.parseLong(requestParam.get("jobId"));
//        Long candidateId = Long.parseLong(requestParam.get("candidateId"));

        return recruiterService.referJob(referJobToCandidateDTO);


    }





}


