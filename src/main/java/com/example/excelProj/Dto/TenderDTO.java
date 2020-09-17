package com.example.excelProj.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

public class TenderDTO implements Serializable {
    Long id;
    String role;
    String description;

    Long userId;
    @NotNull
    String salary;

    @NotNull
    String interviewStartDate;

    @NotNull
    String interviewEndDate;
    String country;
    String city;
    String province;
    String category;
    String type;
    Double longitude;
    Double latitude;
    String address;
    String interviewStartTiming;
    String interviewEndTiming;
    Boolean isActive;

    public TenderDTO(Long id, String role, String description, Long userId, @NotNull String salary, @NotNull String interviewStartDate, @NotNull String interviewEndDate, String country, String city, String province, String category, String type, Double longitude, Double latitude, String address, String interviewStartTiming, String interviewEndTiming, Boolean isActive) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.userId = userId;
        this.salary = salary;
        this.interviewStartDate = interviewStartDate;
        this.interviewEndDate = interviewEndDate;
        this.country = country;
        this.city = city;
        this.province = province;
        this.category = category;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.interviewStartTiming = interviewStartTiming;
        this.interviewEndTiming = interviewEndTiming;
        this.isActive = isActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getInterviewStartDate() {
        return interviewStartDate;
    }

    public void setInterviewStartDate(String interviewStartDate) {
        this.interviewStartDate = interviewStartDate;
    }

    public String getInterviewEndDate() {
        return interviewEndDate;
    }

    public void setInterviewEndDate(String interviewEndDate) {
        this.interviewEndDate = interviewEndDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInterviewStartTiming() {
        return interviewStartTiming;
    }

    public void setInterviewStartTiming(String interviewStartTiming) {
        this.interviewStartTiming = interviewStartTiming;
    }

    public String getInterviewEndTiming() {
        return interviewEndTiming;
    }

    public void setInterviewEndTiming(String interviewEndTiming) {
        this.interviewEndTiming = interviewEndTiming;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public TenderDTO() {
    }
}
