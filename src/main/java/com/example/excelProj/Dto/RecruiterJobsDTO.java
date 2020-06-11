package com.example.excelProj.Dto;

import com.example.excelProj.Model.CandidateProfile;

import java.util.Date;
import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
public class RecruiterJobsDTO {
    Long id;
    String title;
    String description;
    String salary;
    Date publishFrom;
    Date publishTo;
    String country;
    String city;
    String province;
    Double longitude;
    Double latitude;
    String address;
    String category;
    String type;

    public RecruiterJobsDTO(Long id, String title, String description, String salary, Date publishFrom, Date publishTo, String country, String city, String province, Double longitude, Double latitude, String address, String category, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.publishFrom = publishFrom;
        this.publishTo = publishTo;
        this.country = country;
        this.city = city;
        this.province = province;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.category = category;
        this.type = type;
    }

    public RecruiterJobsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getPublishFrom() {
        return publishFrom;
    }

    public void setPublishFrom(Date publishFrom) {
        this.publishFrom = publishFrom;
    }

    public Date getPublishTo() {
        return publishTo;
    }

    public void setPublishTo(Date publishTo) {
        this.publishTo = publishTo;
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
}

