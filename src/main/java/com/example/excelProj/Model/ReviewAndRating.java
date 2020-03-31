package com.example.excelProj.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


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
    Long candidateId;
    @ManyToOne
//    @JsonManagedReference
    @JoinColumn(name = "company_id")
    CompanyProfile companyProfile;


    public ReviewAndRating(String review, Integer rating, Long candidateId, CompanyProfile companyProfile) {
        this.review = review;
        Rating = rating;
        this.candidateId = candidateId;
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

    public CompanyProfile getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }
}
