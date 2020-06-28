package com.example.excelProj.Dto;

/**
 * Created by Rehan on 6/27/2020.
 */
public class UserProfilesDTO {


    Long id;
    String name;
    String corporateAddress;
    String billingAddress;
    String contactName;
    String contactTitle;
    byte[] dp;
    String dpContentType;
    String resumeContentType;
    byte[] resume;
    String certificateContentType;
    byte[] certificate;
    Double avgRating;
    String presentationLetter;
    String field;
    String email;



    public UserProfilesDTO() {
    }

    public UserProfilesDTO(Long id, String name, String corporateAddress, String billingAddress, String contactName, String contactTitle, byte[] dp, String dpContentType, String resumeContentType, byte[] resume, String certificateContentType, byte[] certificate, Double avgRating, String presentationLetter, String field, String email) {
        this.id = id;
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
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
