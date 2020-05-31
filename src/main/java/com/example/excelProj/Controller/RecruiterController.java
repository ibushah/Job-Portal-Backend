package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.RecruiterJobsDTO;
import com.example.excelProj.Dto.ReferJobToCandidateDTO;
import com.example.excelProj.Repository.RecruiterJobRepository;
import com.example.excelProj.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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




    @PostMapping("post/job")
    public ApiResponse postRecruiterJob(@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.postJob(recruiterProfileDTO);
    }

    @PutMapping("update/job/{jobId}")
    public ApiResponse updateRecruiterJob(@PathVariable("jobId") Long jobId,@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.updateJob(jobId,recruiterProfileDTO);
    }

    @GetMapping("get/job/{userId}")
    public ApiResponse getAllJobsOfRecruiterUserId(@PathVariable("userId") Long companyId,@RequestParam(defaultValue = "0")int page){

        org.springframework.data.domain.Pageable pageable = PageRequest.of(page,5);

         return  new ApiResponse(200,"Successfull",recruiterJobRepository.findAllJobsByRecruiterCompanyId(companyId,pageable));
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


