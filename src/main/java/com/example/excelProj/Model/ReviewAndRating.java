package com.example.excelProj.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;


@Entity
public class ReviewAndRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String review;
    @Column
    Integer Rating;
    @Column
    String ratedTo;


    @Column
    String ratedBy;

    @Column
    Date date;
    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "company_id")
    CompanyProfile companyProfile;


    public ReviewAndRating(String review, Integer rating, String ratedTo, String ratedBy, Date date, CompanyProfile companyProfile) {
        this.review = review;
        Rating = rating;
        this.ratedTo = ratedTo;
        this.ratedBy = ratedBy;
        this.date = date;
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

    public String getRatedTo() {
        return ratedTo;
    }

    public void setRatedTo(String ratedTo) {
        this.ratedTo = ratedTo;
    }

    public String getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(String ratedBy) {
        this.ratedBy = ratedBy;
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
}
