package com.example.excelProj.Dto;

import com.example.excelProj.Model.Tender;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

public class TenderDTO implements Serializable {
    Long id;
    String role;
    String description;


    String salary;


    Long recruiterUserId;

    @NotNull
    Long employerUserId;


    String interviewStartDate;


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

    String tenderType;
    Boolean isActive;

    public TenderDTO() {
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
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

    public Long getRecruiterUserId() {
        return recruiterUserId;
    }

    public void setRecruiterUserId(Long recruiterUserId) {
        this.recruiterUserId = recruiterUserId;
    }

    public Long getEmployerUserId() {
        return employerUserId;
    }

    public void setEmployerUserId(Long employerUserId) {
        this.employerUserId = employerUserId;
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

    public TenderDTO(Tender tender) {
        this.id  = tender.getId();
        this.address = tender.getAddress();
        this.category = tender.getCategory();
        this.city = tender.getCity();
        this.country = tender.getCountry();
        this.description = tender.getDescription();
        this.interviewEndDate = tender.getInterviewEndDate();
        this.interviewStartDate = tender.getInterviewStartDate();
        this.isActive = tender.getActive();
        this.latitude = tender.getLatitude();
        this.longitude = tender.getLongitude();
        this.province = tender.getProvince();
        this.role = tender.getRole();
        this.tenderType = tender.getTenderType();
        this.salary = tender.getSalary();
        this.interviewStartTiming = tender.getInterviewStartTiming();
        this.interviewEndTiming  = tender.getInterviewEndTiming();

    }
}
