package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Service.CandidateProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/cp")
public class CandidateProfileController {

    @Autowired
    CandidateProfileService candidateProfileService;

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
}
