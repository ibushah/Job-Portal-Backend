package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Service.CandidateProfileService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/cp")
public class CandidateProfileController {

    @Autowired
    CandidateProfileService candidateProfileService;
    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    @PostMapping("/{userid}")
    public ApiResponse postCandidateProfile(@PathVariable("userid") Long userId, @RequestBody CandidateProfileDTO candidateProfileDTO) {
        return candidateProfileService.postCandidateProfile(userId, candidateProfileDTO);
    }

    @GetMapping("/alreadyappliedjob")
    public ApiResponse getAlreadyAppliedJobs(@RequestParam Map<String,String> requestParams){
        Long jobId = Long.parseLong(requestParams.get("jobId"));
        Long candidateId = Long.parseLong(requestParams.get("candidateId"));
        return candidateProfileService.getAlreadyAppliedJobs(candidateId,jobId);
    }

    @GetMapping("/{userId}")
    public ApiResponse getProfile(@PathVariable("userId") Long userId){
        return candidateProfileService.getCandidateProfile(userId);
    }


    @GetMapping("/complete")
    public ApiResponse getProfile(@RequestParam Map<String,String> requestParams){
        Long userId = Long.parseLong(requestParams.get("userId"));
        Long candidateId = Long.parseLong(requestParams.get("candidateId"));
        return candidateProfileService.getCandidateProfileComplete(userId,candidateId);
    }

    @GetMapping("/")
    public ApiResponse imageIsUploading(){
        return new ApiResponse(200,"SUCCESS",true);
    }


}
