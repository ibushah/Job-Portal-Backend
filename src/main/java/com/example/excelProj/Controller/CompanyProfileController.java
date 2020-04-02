package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDetailsDTO;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Dto.CompanyProfileDTO;
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

    @PostMapping("/{userId}")
    public ApiResponse postCompanyProfile(@PathVariable("userId") Long userId, @RequestBody CompanyProfileDTO companyProfileDTO) {
        return companyProfileService.postCompanyProfile(userId, companyProfileDTO);
    }

    @GetMapping("/{companyId}")
    public CompanyProfileDetailsDTO getCompanyProfile(@PathVariable("companyId") Long id) {
        return companyProfileService.getCompanyProfile(id);
    }


//    @GetMapping("/{userId}")
//    public ApiResponse getCompanyById(@PathVariable("userId") Long userId){
//        return  companyProfileService.getCompanyCreatedByEmployer(Long userId)
//    }
}
