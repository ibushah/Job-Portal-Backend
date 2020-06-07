package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Chat {


    @Id
    @GeneratedValue
    Long id;

    String message;

    @ManyToOne
    User from;

    @ManyToOne
    User to;

    Date date;


    @ManyToOne
    @JsonIgnore
    Chatroom chatroom;


    public Chat(String message, User from, User to, Date date, Chatroom chatroom) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.date = date;
        this.chatroom = chatroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }
}
