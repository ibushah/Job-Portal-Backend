package com.example.excelProj.Dto;

import com.example.excelProj.Model.Job;

import java.util.List;

public class CompanyProfileDTO {

    Long id;
    String name;
    String corporateAddress;
    String billingAddress;
    String contactName;
    String contactTitle;
    byte[] logo;
    byte[] resume;
    byte[] certificate;
    String logoContentType;
//    List<Job> jobList;

    String resumeContentType;

    String certificateContentType;

    public CompanyProfileDTO() {
    }

    public CompanyProfileDTO(Long id, String name, String corporateAddress, String billingAddress, String contactName, String contactTitle, byte[] logo, byte[] resume, byte[] certificate, String logoContentType, String resumeContentType, String certificateContentType) {
        this.id = id;
        this.name = name;
        this.corporateAddress = corporateAddress;
        this.billingAddress = billingAddress;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.logo = logo;
        this.resume = resume;
        this.certificate = certificate;
        this.logoContentType = logoContentType;
        this.resumeContentType = resumeContentType;
        this.certificateContentType = certificateContentType;
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
}
