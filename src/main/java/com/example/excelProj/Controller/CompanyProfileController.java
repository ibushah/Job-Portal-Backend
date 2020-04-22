package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDetailsDTO;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.AppliedFor;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Repository.AppliedForRepository;
import com.example.excelProj.Repository.CompanyProfileRepository;
import com.example.excelProj.Service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @PostMapping("/{userId}")
    public ApiResponse postCompanyProfile(@PathVariable("userId") Long userId, @RequestBody CompanyProfileDTO companyProfileDTO) {
        return companyProfileService.postCompanyProfile(userId, companyProfileDTO);
    }

    @GetMapping("/{companyId}")
    public CompanyProfileDetailsDTO getCompanyProfile(@PathVariable("companyId") Long id) {
        return companyProfileService.getCompanyProfile(id);
    }


    @GetMapping("/userId/{userId}")
    public ApiResponse<CompanyProfile> getCompanyById(@PathVariable("userId") Long userId){
        return companyProfileService.findCompanybyUserId(userId);
    }

    @GetMapping("/notify/{id}")
    public List<NotificationDTO> getNotificationsByCompanyId(@PathVariable("id") Long id)
    {

      return  appliedForRepository.getNotifications(id);
    }

    @GetMapping("/notification_count/{companyId}")
    public Long getNotificationsCount(@PathVariable("companyId") Long id)
    {
        return appliedForRepository.getNotificationsCount(id);
    }
}
