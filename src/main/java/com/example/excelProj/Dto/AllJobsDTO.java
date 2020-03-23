package com.example.excelProj.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

public class AllJobsDTO implements Serializable {

    Long id;
    String title;
    String description;
    String city;
    byte[] logo;
    String logoContentType;
    String category;
    Double longitude;
    Double latitude;


//    public AllJobsDTO(String title) {
//        this.title = title;
//    }


    public AllJobsDTO(Long id, String title, String description, String city, byte[] logo, String logoContentType, String category, Double longitude, Double latitude) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city = city;
        this.logo = logo;
        this.logoContentType = logoContentType;
        this.category = category;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void setLatitiude(Double latitude) {
        this.latitude = latitude;
    }

    public AllJobsDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    public AllJobsDTO(String title) {
//        this.title = title;
//    }

    //    String description;
//    String city;
//    byte[] logo;
//    String logoContentType;
//    String category;
//    Double longitude;
//    Double latitude;
}
