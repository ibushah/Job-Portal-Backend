package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
public class ReferJobToCandidateDTO {
    Long userId;
    Long jobId;
    List<Long> candidateProfilesIds;

    public ReferJobToCandidateDTO() {
    }

    public ReferJobToCandidateDTO(Long userId, Long jobId, List<Long> candidateProfilesIds) {
        this.userId = userId;
        this.jobId = jobId;
        this.candidateProfilesIds = candidateProfilesIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
