package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by Rehan on 6/27/2020.
 */
@Entity
@Table(name = "userProfiles")
public class UserProfiles{

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
    byte[] dp;


    @Column
    String dpContentType;


    @Column
    String resumeContentType;

    @Lob
    byte[] resume;


    @Column
    String certificateContentType;

    @Lob
    byte[] certificate;


    @Column
    Double avgRating;


    @Column(columnDefinition = "LONGTEXT")
    String presentationLetter;

    @Column
    String field;


    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    public UserProfiles() {
    }

    public UserProfiles(String name, String corporateAddress, String billingAddress, String contactName, String contactTitle, byte[] dp, String dpContentType, String resumeContentType, byte[] resume, String certificateContentType, byte[] certificate, Double avgRating, String presentationLetter, String field, User user) {
        this.name = name;
        this.corporateAddress = corporateAddress;
        this.billingAddress = billingAddress;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.dp = dp;
        this.dpContentType = dpContentType;
        this.resumeContentType = resumeContentType;
        this.resume = resume;
        this.certificateContentType = certificateContentType;
        this.certificate = certificate;
        this.avgRating = avgRating;
        this.presentationLetter = presentationLetter;
        this.field = field;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public byte[] getDp() {
        return dp;
    }

    public void setDp(byte[] dp) {
        this.dp = dp;
    }

    public String getDpContentType() {
        return dpContentType;
    }

    public void setDpContentType(String dpContentType) {
        this.dpContentType = dpContentType;
    }

    public String getResumeContentType() {
        return resumeContentType;
    }

    public void setResumeContentType(String resumeContentType) {
        this.resumeContentType = resumeContentType;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public String getCertificateContentType() {
        return certificateContentType;
    }

    public void setCertificateContentType(String certificateContentType) {
        this.certificateContentType = certificateContentType;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public String getPresentationLetter() {
        return presentationLetter;
    }

    public void setPresentationLetter(String presentationLetter) {
        this.presentationLetter = presentationLetter;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
