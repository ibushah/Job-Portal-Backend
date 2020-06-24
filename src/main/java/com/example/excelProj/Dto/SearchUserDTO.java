package com.example.excelProj.Dto;

import java.util.Date;

/**
 * Created by Rehan on 6/11/2020.
 */
public class SearchUserDTO
{
    String name;
    String userType;
    Long userId;
    Long profileId;
    byte[] dp;
    String message;
    Date date;


    public SearchUserDTO(String name, String userType, Long userId, Long profileId, byte[] dp) {
        this.name = name;
        this.userType = userType;
        this.userId = userId;
        this.profileId = profileId;
        this.dp = dp;
    }

    public SearchUserDTO(String name, String userType, Long userId, Long profileId, byte[] dp, String message, Date date) {
        this.name = name;
        this.userType = userType;
        this.userId = userId;
        this.profileId = profileId;
        this.dp = dp;
        this.message = message;
        this.date = date;
    }

    public SearchUserDTO() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public byte[] getDp() {
        return dp;
    }

    public void setDp(byte[] dp) {
        this.dp = dp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
