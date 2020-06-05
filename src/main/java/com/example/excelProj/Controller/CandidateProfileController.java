package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.AppliedForRecruiterJobRepository;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.CandidateProfileService;
import org.hibernate.hql.internal.classic.AbstractParameterInformation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/cp")
public class CandidateProfileController {

    @Autowired
    CandidateProfileService candidateProfileService;
    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    AppliedForRecruiterJobRepository appliedForRecruiterJobRepository;

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
    public ApiResponse getProfile(@RequestParam(required = false) Map<String,String> requestParams){
        Long userId  = Long.parseLong(requestParams.get("userId"));
        Long candidateId = 0l;
        if(userId==0){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            User user = userDaoRepository.findByEmail(currentPrincipalName);
            userId = user.getId();
            candidateId = user.getCandidateProfile().getId();
            return candidateProfileService.getCandidateProfileComplete(userId,candidateId);

        }
        userId= Long.parseLong(requestParams.get("userId"));
        candidateId = Long.parseLong(requestParams.get("candidateId"));
        return candidateProfileService.getCandidateProfileComplete(userId,candidateId);

    }

    @GetMapping("/")
    public ApiResponse imageIsUploading(){
        return new ApiResponse(200,"SUCCESS",true);
    }

    @GetMapping("/getall")
    public ApiResponse getAllCandidationPagintation(@RequestParam(defaultValue ="0")int page){

//        get all candidates
        return  new ApiResponse(200,"SUCCESSSFULL",candidateProfileRepository.findAll(PageRequest.of(page,5)));
    }


    @GetMapping("/notifications/{id}")
    public Page<NotificationDTO> getNotificationsByCandidateId(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") int page) {

        return appliedForRecruiterJobRepository.getNotifications(id, PageRequest.of(page,5));
    }

    @GetMapping("/notification_count/{candidateId}")
    public Long getNotificationsCount(@PathVariable(value = "candidateId",required = false) Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        id = user.getCandidateProfile().getId();
        return appliedForRecruiterJobRepository.getNotificationsCount(id);
    }

    @GetMapping("/notifications_read/{candidateId}")
    public ApiResponse markAllNoticationsRead(@PathVariable("candidateId") Long id) {

        appliedForRecruiterJobRepository.setAllNoticationsAsRead(id);
        return  new ApiResponse<>(200,"All notifications read",appliedForRecruiterJobRepository.getNotifications(id,PageRequest.of(0,5)));
    }

    @GetMapping("/notification_marked")
    public ApiResponse markSelectedNotificationAsRead(@RequestParam Map<String,String> requestParms) {
        Long candidateId=Long.parseLong(requestParms.get("candidateId"));
        Long jobId=Long.parseLong(requestParms.get("jobId"));
        appliedForRecruiterJobRepository.setSelectedNotificationAsRead(candidateId,jobId);
        return    new ApiResponse<>(200,"notification read",appliedForRecruiterJobRepository.getNotifications(candidateId,PageRequest.of(0,5)));
    }


}
