package com.example.excelProj.Dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rehan on 6/1/2020.
 */
public class AllCandidatesReferedOrNotList  implements Serializable{
    Long user_id;
    String name;
    Long candidate_id;
    byte[] dp;
    String presentationLetter;
    String imageContentType;
    Date appliedDate;
    Boolean isApplied;
    Boolean isSeen;
    Date referedDate;


    public AllCandidatesReferedOrNotList() {
    }

    public AllCandidatesReferedOrNotList(Long user_id, String name, Long candidate_id, byte[] dp, String presentationLetter, String imageContentType, Date appliedDate, Boolean isApplied, Boolean isSeen, Date referedDate) {
        this.user_id = user_id;
        this.name = name;
        this.candidate_id = candidate_id;
        this.dp = dp;
        this.presentationLetter = presentationLetter;
        this.imageContentType = imageContentType;
        this.appliedDate = appliedDate;
        this.isApplied = isApplied;
        this.isSeen = isSeen;
        this.referedDate = referedDate;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(Long candidate_id) {
        this.candidate_id = candidate_id;
    }

    public byte[] getDp() {
        return dp;
    }

    public void setDp(byte[] dp) {
        this.dp = dp;
    }

    public String getPresentationLetter() {
        return presentationLetter;
    }

    public void setPresentationLetter(String presentationLetter) {
        this.presentationLetter = presentationLetter;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public Date getReferedDate() {
        return referedDate;
    }

    public void setReferedDate(Date referedDate) {
        this.referedDate = referedDate;
    }
}
