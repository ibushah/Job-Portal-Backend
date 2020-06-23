package com.example.excelProj.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    Long sender;

    String message;

    String chatroomId;

    Date date;

    public Chat(Long sender, String message, String chatroomId, Date date) {
        this.sender = sender;
        this.message = message;
        this.chatroomId = chatroomId;
        this.date = date;
    }

    public Chat() {
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
