package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

import java.io.Serializable;
import java.util.Date;

public class ChatroomDTO implements Serializable {

    User user;
    String message;
    String chatroomId;
    Date date;


    public ChatroomDTO(User user, String message, String chatroomId, Date date) {
        this.user = user;
        this.message = message;
        this.chatroomId = chatroomId;
        this.date = date;
    }

    public ChatroomDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(String chatroomId) {
        this.chatroomId = chatroomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
