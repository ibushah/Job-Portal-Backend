package com.example.excelProj.Dto;

/**
 * Created by Rehan on 4/24/2020.
 */
public class LoginPageDetails {

    Long numberOfRegisteredCandidates;
    Long numberOfCompaniesRegistered;
    Long numberOfJobsAvailable;
    Long numOfRegisteredUser;

    public LoginPageDetails(Long numberOfRegisteredCandidates, Long numberOfCompaniesRegistered, Long numberOfJobsAvailable, Long numOfRegisteredUser) {
        this.numberOfRegisteredCandidates = numberOfRegisteredCandidates;
        this.numberOfCompaniesRegistered = numberOfCompaniesRegistered;
        this.numberOfJobsAvailable = numberOfJobsAvailable;
        this.numOfRegisteredUser = numOfRegisteredUser;
    }

    public LoginPageDetails(Long numberOfRegisteredCandidates, Long numberOfCompaniesRegistered, Long numberOfJobsAvailable) {
        this.numberOfRegisteredCandidates = numberOfRegisteredCandidates;
        this.numberOfCompaniesRegistered = numberOfCompaniesRegistered;
        this.numberOfJobsAvailable = numberOfJobsAvailable;
    }

    public LoginPageDetails() {
    }

    public Long getNumberOfRegisteredCandidates() {
        return numberOfRegisteredCandidates;
    }

    public void setNumberOfRegisteredCandidates(Long numberOfRegisteredCandidates) {
        this.numberOfRegisteredCandidates = numberOfRegisteredCandidates;
    }

    public Long getNumberOfCompaniesRegistered() {
        return numberOfCompaniesRegistered;
    }

    public void setNumberOfCompaniesRegistered(Long numberOfCompaniesRegistered) {
        this.numberOfCompaniesRegistered = numberOfCompaniesRegistered;
    }

    public Long getNumberOfJobsAvailable() {
        return numberOfJobsAvailable;
    }

    public void setNumberOfJobsAvailable(Long numberOfJobsAvailable) {
        this.numberOfJobsAvailable = numberOfJobsAvailable;
    }

    public Long getNumOfRegisteredUser() {
        return numOfRegisteredUser;
    }

    public void setNumOfRegisteredUser(Long numOfRegisteredUser) {
        this.numOfRegisteredUser = numOfRegisteredUser;
    }
}
