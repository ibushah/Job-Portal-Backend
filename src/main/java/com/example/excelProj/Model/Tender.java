package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Tender{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    Long id;

    @Column(nullable = false)
    String role;

    @Column(columnDefinition = "LONGTEXT")
    String description;

    @Column
    String salary;

    @Column
    String interviewStartDate;

    @Column
    String interviewEndDate;

    @Column
    String country;

    @Column
    String city;

    @Column
    String province;

    @Column
    String category;

    @Column
    String type;


    @Column
    Double longitude;

    @Column
    Double latitude;


    @Column(columnDefinition = "LONGTEXT")
    String address;


    @OneToOne(mappedBy = "tender")
    @JsonBackReference
    TenderAssortments tenderAssortments;



    @Column
    String interviewStartTiming;

    @Column
    String getInterviewEndTiming;

    @Column
    Boolean isActive;


    @ManyToOne
    @JoinColumn(name = "tender_poster_id")
    @JsonIgnoreProperties("tender")
    public User tenderPoster;

    @Column
    String tenderType;

    public Tender(Long id, String role, String description, String salary, String interviewStartDate, String interviewEndDate, String country, String city, String province, String category, String type, Double longitude, Double latitude, String address, TenderAssortments tenderAssortments, String interviewStartTiming, String getInterviewEndTiming, Boolean isActive, User tenderPoster, String tenderType) {
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
        this.tenderAssortments = tenderAssortments;
        this.interviewStartTiming = interviewStartTiming;
        this.getInterviewEndTiming = getInterviewEndTiming;
        this.isActive = isActive;
        this.tenderPoster = tenderPoster;
        this.tenderType = tenderType;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public User getTenderPoster() {
        return tenderPoster;
    }

    public void setTenderPoster(User tenderPoster) {
        this.tenderPoster = tenderPoster;
    }

    public String getInterviewStartTiming() {
        return interviewStartTiming;
    }

    public void setInterviewStartTiming(String interviewStartTiming) {
        this.interviewStartTiming = interviewStartTiming;
    }

    public String getGetInterviewEndTiming() {
        return getInterviewEndTiming;
    }

    public void setGetInterviewEndTiming(String getInterviewEndTiming) {
        this.getInterviewEndTiming = getInterviewEndTiming;
    }

    public Tender() {
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

    public TenderAssortments getTenderAssortments() {
        return tenderAssortments;
    }

    public void setTenderAssortments(TenderAssortments tenderAssortments) {
        this.tenderAssortments = tenderAssortments;
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


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
