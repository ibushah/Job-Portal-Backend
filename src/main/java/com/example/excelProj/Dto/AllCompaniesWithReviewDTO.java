package com.example.excelProj.Dto;

import com.example.excelProj.Model.Job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Rehan on 4/14/2020.
 */
public class AllCompaniesWithReviewDTO implements Serializable{
    Long id;
    String name;
    String email;
    String corporateAddress;
    String billingAddress;
    String contactName;
    String contactTitle;
    byte[] logo;
    String logoContentType;
    String review;
    Integer Rating;
    Date date;

    public AllCompaniesWithReviewDTO() {
    }

    public AllCompaniesWithReviewDTO(Long id, String name, String email, String corporateAddress, String billingAddress, String contactName, String contactTitle, byte[] logo, String logoContentType, String review, Integer rating, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.corporateAddress = corporateAddress;
        this.billingAddress = billingAddress;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.logo = logo;
        this.logoContentType = logoContentType;
        this.review = review;
        Rating = rating;
        this.date = date;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
