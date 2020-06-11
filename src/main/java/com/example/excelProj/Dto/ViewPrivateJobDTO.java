package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.RecruiterJobs;

import java.util.List;

/**
 * Created by Rehan on 6/1/2020.
 */
public class ViewPrivateJobDTO {


    RecruiterJobs recruiterJobs;
    List<AllCandidatesReferedOrNotList> AllCandidatesReferedOrNotList;
    List<CandidateProfile> candidateProfiles;

    public ViewPrivateJobDTO(RecruiterJobs recruiterJobs, List<com.example.excelProj.Dto.AllCandidatesReferedOrNotList> allCandidatesReferedOrNotList, List<CandidateProfile> candidateProfiles) {
        this.recruiterJobs = recruiterJobs;
        AllCandidatesReferedOrNotList = allCandidatesReferedOrNotList;
        this.candidateProfiles = candidateProfiles;
    }

    public ViewPrivateJobDTO() {
    }

    public ViewPrivateJobDTO(RecruiterJobs recruiterJobs, List<com.example.excelProj.Dto.AllCandidatesReferedOrNotList> allCandidatesReferedOrNotList) {
        this.recruiterJobs = recruiterJobs;
        this.AllCandidatesReferedOrNotList = allCandidatesReferedOrNotList;
    }

    public RecruiterJobs getRecruiterJobs() {
        return recruiterJobs;
    }

    public void setRecruiterJobs(RecruiterJobs recruiterJobs) {
        this.recruiterJobs = recruiterJobs;
    }

    public List<com.example.excelProj.Dto.AllCandidatesReferedOrNotList> getAllCandidatesReferedOrNotList() {
        return AllCandidatesReferedOrNotList;
    }

    public void setAllCandidatesReferedOrNotList(List<com.example.excelProj.Dto.AllCandidatesReferedOrNotList> allCandidatesReferedOrNotList) {
        AllCandidatesReferedOrNotList = allCandidatesReferedOrNotList;
    }

    public List<CandidateProfile> getCandidateProfiles() {
        return candidateProfiles;
    }

    public void setCandidateProfiles(List<CandidateProfile> candidateProfiles) {
        this.candidateProfiles = candidateProfiles;
    }
}
