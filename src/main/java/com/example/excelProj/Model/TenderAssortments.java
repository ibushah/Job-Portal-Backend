package com.example.excelProj.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tender_assortments")
public class TenderAssortments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JsonIgnoreProperties("tender_assortments")
    User employer;

    @ManyToOne
    @JsonIgnoreProperties("tender_assortments")
    User recruiter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tender_id", referencedColumnName = "id")
    @JsonManagedReference
    Tender tender;

    @Column
    String notifcationFrom;

    @Column
    String notificationFor;

    @Column
    Boolean isSeen;

    @Column
    Date notificationDate;

    @Column
    Boolean isApplied;

    public TenderAssortments(Long id, User employer, User recruiter, Tender tender, String notifcationFrom, String notificationFor, Boolean isSeen) {
        this.id = id;
        this.employer = employer;
        this.recruiter = recruiter;
        this.tender = tender;
        this.notifcationFrom = notifcationFrom;
        this.notificationFor = notificationFor;
        this.isSeen = isSeen;
    }

    public Boolean getApplied() {
        return isApplied;
    }

    public void setApplied(Boolean applied) {
        isApplied = applied;
    }

    public TenderAssortments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmployer() {
        return employer;
    }

    public void setEmployer(User employer) {
        this.employer = employer;
    }

    public User getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(User recruiter) {
        this.recruiter = recruiter;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public String getNotifcationFrom() {
        return notifcationFrom;
    }

    public void setNotifcationFrom(String notifcationFrom) {
        this.notifcationFrom = notifcationFrom;
    }

    public String getNotificationFor() {
        return notificationFor;
    }

    public void setNotificationFor(String notificationFor) {
        this.notificationFor = notificationFor;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }
}
