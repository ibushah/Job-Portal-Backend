package com.example.excelProj.Controller;

import com.example.excelProj.Dto.LoginPageDetails;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Repository.CompanyProfileRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rehan on 4/24/2020.
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginPageController {

    @Autowired
    UserDaoRepository userDaoRepository;
    @Autowired
    CompanyProfileRepository companyProfileRepository;
    @Autowired
    CandidateProfileRepository candidateProfileRepository;
    @Autowired
    JobRepository jobRepository;


    @GetMapping("/login_information")
    public LoginPageDetails loginPageDetails(){
        LoginPageDetails loginPageDetails = new LoginPageDetails();
        loginPageDetails.setNumberOfJobsAvailable(jobRepository.count());
        loginPageDetails.setNumberOfCompaniesRegistered(companyProfileRepository.count());
        loginPageDetails.setNumberOfRegisteredCandidates(candidateProfileRepository.count());
        loginPageDetails.setNumOfRegisteredUser(userDaoRepository.count());
        return loginPageDetails;

    }
}
