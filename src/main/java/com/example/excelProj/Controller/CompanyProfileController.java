package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/companyprofile")
public class CompanyProfileController {

    @Autowired
    CompanyProfileService companyProfileService;

    @PostMapping("/{userId}")
    public ApiResponse postCompanyProfile(@PathVariable("userId") Long userId, @RequestBody CompanyProfileDTO companyProfileDTO)
    {
        return companyProfileService.postCompanyProfile(userId,companyProfileDTO);
    }







//    @GetMapping("/{userId}")
//    public ApiResponse getCompanyById(@PathVariable("userId") Long userId){
//        return  companyProfileService.getCompanyCreatedByEmployer(Long userId)
//    }
}
