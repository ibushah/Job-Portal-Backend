package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rehan on 5/28/2020.
 */
@Entity
@Table(name = "recruiter_jobs")
public class RecruiterJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;


    @Column(columnDefinition = "LONGTEXT")
    String description;

    @Column
    String salary;

    @Column
    Date publishFrom;

    @Column
    Date publishTo;

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

    @Column
    Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    User user;


    @JsonIgnore
    @OneToMany(mappedBy = "recruiterJobs", cascade = CascadeType.ALL)
    private Set<AppliedForRecruiterJob> appliedForRecruiterJobs;

    public RecruiterJobs() {

    }

    public RecruiterJobs(String title, String description, String salary, Date publishFrom, Date publishTo, String country, String city, String province, String category, String type, Double longitude, Double latitude, String address, Date date, User user, Set<AppliedForRecruiterJob> appliedForRecruiterJobs) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.publishFrom = publishFrom;
        this.publishTo = publishTo;
        this.country = country;
        this.city = city;
        this.province = province;
        this.category = category;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.date = date;
        this.user = user;
        this.appliedForRecruiterJobs = appliedForRecruiterJobs;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AppliedForRecruiterJob> getAppliedForRecruiterJobs() {
        return appliedForRecruiterJobs;
    }

    public void setAppliedForRecruiterJobs(Set<AppliedForRecruiterJob> appliedForRecruiterJobs) {
        this.appliedForRecruiterJobs = appliedForRecruiterJobs;
    }
}
