package com.example.excelProj.Dto;

public class CvBuilderDTO {
    // personal information
    String firstName;
    String lastName;
    String profession;
    String city;
    String zipCode;
    String phone;
    String emailAddress;
    String socialMediaLinks;
    // Experince
   String jobHistory;
   //Education
    String education;
    //skills
    String skills;
    String professionalSummary;
    String softwareSkills;
    String languages;
    String interests;

    public CvBuilderDTO() {
    }

    public CvBuilderDTO(String firstName, String lastName, String profession, String city, String zipCode, String phone, String emailAddress, String socialMediaLinks, String jobHistory, String education, String skills, String professionalSummary, String softwareSkills, String languages, String interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.socialMediaLinks = socialMediaLinks;
        this.jobHistory = jobHistory;
        this.education = education;
        this.skills = skills;
        this.professionalSummary = professionalSummary;
        this.softwareSkills = softwareSkills;
        this.languages = languages;
        this.interests = interests;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(String socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public String getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(String jobHistory) {
        this.jobHistory = jobHistory;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }

    public String getSoftwareSkills() {
        return softwareSkills;
    }

    public void setSoftwareSkills(String softwareSkills) {
        this.softwareSkills = softwareSkills;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
