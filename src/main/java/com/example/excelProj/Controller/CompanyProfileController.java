package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDetailsDTO;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.AppliedFor;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.AppliedForRepository;
import com.example.excelProj.Repository.CompanyProfileRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/companyprofile")
public class CompanyProfileController {

    @Autowired
    CompanyProfileService companyProfileService;

    @Autowired
    AppliedForRepository appliedForRepository;

    @Autowired
    CompanyProfileRepository companyProfileRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @PostMapping("/{userId}")
    public ApiResponse postCompanyProfile(@PathVariable(value = "userId",required = false) Long userId, @RequestBody CompanyProfileDTO companyProfileDTO) {
        return companyProfileService.postCompanyProfile(userId, companyProfileDTO);
    }

    @GetMapping("/{companyId}")
    public CompanyProfileDetailsDTO getCompanyProfile(@PathVariable("companyId") Long id) {
        return companyProfileService.getCompanyProfile(id);
    }


    @GetMapping("/userId/{userId}")
    public ApiResponse<CompanyProfile> getCompanyById(@PathVariable("userId") Long userId) {
        return companyProfileService.findCompanybyUserId(userId);
    }

    @GetMapping("/notifications/{id}")
    public Page<NotificationDTO> getNotificationsByCompanyId(@PathVariable("id") Long id,@RequestParam(defaultValue = "0") int page) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        id = user.getCandidateProfile().getId();
        return appliedForRepository.getNotifications(id, PageRequest.of(page,5));
    }

    @GetMapping("/notification_count/{companyId}")
    public Long getNotificationsCount(@PathVariable("companyId") Long id) {
        return appliedForRepository.getNotificationsCount(id);
    }

    @GetMapping("/notifications_read/{companyId}")
    public ApiResponse markAllNoticationsRead(@PathVariable("companyId") Long id) {

        appliedForRepository.setAllNoticationsAsRead(id);
        return  new ApiResponse<>(200,"All notifications read",appliedForRepository.getNotifications(id,PageRequest.of(0,5)));
    }

    @GetMapping("/notification_marked")
    public ApiResponse markAllNoticationsRead(@RequestParam Map<String,String> requestParms) {
        Long companyId=Long.parseLong(requestParms.get("companyId"));
        Long jobId=Long.parseLong(requestParms.get("jobId"));
        appliedForRepository.setSelectedNotificationAsRead(companyId,jobId);
        return    new ApiResponse<>(200,"notification read",appliedForRepository.getNotifications(companyId,PageRequest.of(0,5)));
    }



}
