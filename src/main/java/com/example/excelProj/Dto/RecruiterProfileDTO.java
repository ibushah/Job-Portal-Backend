package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

/**
 * Created by Rehan on 5/28/2020.
 */
public class RecruiterProfileDTO {

    String name;


    String corporateAddress;


    String billingAddress;

    String contactName;




    byte[] logo;


    byte[] resume;

    byte[] certificate;


    String logoContentType;





    String resumeContentType;

    String certificateContentType;



    public RecruiterProfileDTO() {
    }

    public RecruiterProfileDTO(String name, String corporateAddress, String billingAddress, String contactName, byte[] logo, byte[] resume, byte[] certificate, String logoContentType, String resumeContentType, String certificateContentType) {
        this.name = name;
        this.corporateAddress = corporateAddress;
        this.billingAddress = billingAddress;
        this.contactName = contactName;
        this.logo = logo;
        this.resume = resume;
        this.certificate = certificate;
        this.logoContentType = logoContentType;

        this.resumeContentType = resumeContentType;
        this.certificateContentType = certificateContentType;
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
