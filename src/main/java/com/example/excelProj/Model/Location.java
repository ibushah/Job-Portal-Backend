package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double longitude;

    Double latitiude;

    @JsonIgnore
    @OneToOne
    User user;

    public Location(Double longitude, Double latitiude, User user) {
        this.longitude = longitude;
        this.latitiude = latitiude;
        this.user = user;
    }

    public Location() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitiude() {
        return latitiude;
    }

    public void setLatitiude(Double latitiude) {
        this.latitiude = latitiude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
