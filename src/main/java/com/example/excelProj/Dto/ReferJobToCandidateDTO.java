package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
public class ReferJobToCandidateDTO {
    Long companyId;
    Long jobId;
    Long  candidateId;

    public ReferJobToCandidateDTO() {
    }

    public ReferJobToCandidateDTO(Long companyId, Long jobId, Long candidateId) {
        this.companyId = companyId;
        this.jobId = jobId;
        this.candidateId = candidateId;
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

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}
