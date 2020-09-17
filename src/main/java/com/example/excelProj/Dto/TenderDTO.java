package com.example.excelProj.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

public class TenderDTO implements Serializable {
    Long id;
    String role;
    String description;


    String salary;

    @NotNull
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
    LocalTime interviewTimings;
    Boolean isActive;


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

    public TenderDTO(Long id, String role, String description, @NotNull String salary, @NotNull String interviewStartDate, @NotNull String interviewEndDate, String country, String city, String province, String category, String type, Double longitude, Double latitude, String address, LocalTime interviewTimings, Boolean isActive) {
        this.id = id;
        this.role = role;
        this.description = description;
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
        this.interviewTimings = interviewTimings;
        this.isActive = isActive;
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

    public LocalTime getInterviewTimings() {
        return interviewTimings;
    }

    public void setInterviewTimings(LocalTime interviewTimings) {
        this.interviewTimings = interviewTimings;
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
