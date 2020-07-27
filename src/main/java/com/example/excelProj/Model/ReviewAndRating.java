package com.example.excelProj.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;


@Entity
public class ReviewAndRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(columnDefinition = "LONGTEXT")
    String review;
    @Column
    Integer Rating;
    @Column
    Long candidateId;
    @Column
    String rateBy;
    @Column
    Date date;

    @Column
    String type;

    @Column
    String videoUrl;





    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "company_id")
    CompanyProfile companyProfile;


    public ReviewAndRating(String review, Integer rating, Long candidateId, String rateBy, Date date, CompanyProfile companyProfile) {
        this.review = review;
        Rating = rating;
        this.candidateId = candidateId;
        this.rateBy = rateBy;
        this.date = date;
        this.companyProfile = companyProfile;
    }

    public ReviewAndRating(String review, Integer rating, Long candidateId, String rateBy, Date date, String type, String videoUrl, CompanyProfile companyProfile) {
        this.review = review;
        Rating = rating;
        this.candidateId = candidateId;
        this.rateBy = rateBy;
        this.date = date;
        this.type = type;
        this.videoUrl = videoUrl;
        this.companyProfile = companyProfile;
    }

    public ReviewAndRating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        Rating = rating;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getRateBy() {
        return rateBy;
    }

    public void setRateBy(String rateBy) {
        this.rateBy = rateBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }


    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
