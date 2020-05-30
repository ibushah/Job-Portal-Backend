package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
@Entity
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column(columnDefinition = "LONGTEXT")
    String corporateAddress;

    @Column
    String billingAddress;

    @Column
    String contactName;

    @Column
    String contactTitle;

    @Lob
    byte[] logo;

    @Lob
    byte[] resume;

    @Lob
    byte[] certificate;

    @Column
    String logoContentType;

    @Column
    Double avgRating;

    @Column
    String resumeContentType;

    @Column
    String certificateContentType;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    User user;


    @OneToMany(mappedBy="recruiterProfile")
    @JsonBackReference(value = "recruiter_reviews_reference")
    List<ReviewAndRating> reviewAndRatings;




    public RecruiterProfile() {
    }

    public RecruiterProfile(String name, String corporateAddress, String billingAddress, String contactName, String contactTitle, byte[] logo, byte[] resume, byte[] certificate, String logoContentType, Double avgRating, String resumeContentType, String certificateContentType, User user, List<ReviewAndRating> reviewAndRatings) {
        this.name = name;
        this.corporateAddress = corporateAddress;
        this.billingAddress = billingAddress;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.logo = logo;
        this.resume = resume;
        this.certificate = certificate;
        this.logoContentType = logoContentType;
        this.avgRating = avgRating;
        this.resumeContentType = resumeContentType;
        this.certificateContentType = certificateContentType;
        this.user = user;
        this.reviewAndRatings = reviewAndRatings;
    }

    public Long getId() {
        return id;
    }

    public List<ReviewAndRating> getReviewAndRatings() {
        return reviewAndRatings;
    }

    public void setReviewAndRatings(List<ReviewAndRating> reviewAndRatings) {
        this.reviewAndRatings = reviewAndRatings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporateAddress() {
        return corporateAddress;
    }

    public void setCorporateAddress(String corporateAddress) {
        this.corporateAddress = corporateAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

    public String getCertificateContentType() {
        return certificateContentType;
    }

    public void setCertificateContentType(String certificateContentType) {
        this.certificateContentType = certificateContentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
