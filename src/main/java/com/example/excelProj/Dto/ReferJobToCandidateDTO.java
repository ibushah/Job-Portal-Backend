package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
public class ReferJobToCandidateDTO {
    Long companyId;
    Long jobId;
    List<Long> candidateProfilesIds;

    public ReferJobToCandidateDTO() {
    }

    public ReferJobToCandidateDTO(Long companyId, Long jobId, List<Long> candidateProfilesIds) {
        this.companyId = companyId;
        this.jobId = jobId;
        this.candidateProfilesIds = candidateProfilesIds;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public List<Long> getCandidateProfilesIds() {
        return candidateProfilesIds;
    }

    public void setCandidateProfilesIds(List<Long> candidateProfilesIds) {
        this.candidateProfilesIds = candidateProfilesIds;
    }
}
