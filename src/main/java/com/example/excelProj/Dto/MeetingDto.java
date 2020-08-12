package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

import java.io.Serializable;
import java.util.Date;

public class MeetingDto implements Serializable {

Long id;
    User friend;

    String meetingId;


    String status;

    Boolean self;


    Boolean seen;

    Date date;


    public MeetingDto() {
    }

    public MeetingDto(Long id, User friend, String meetingId, String status, Boolean self, Boolean seen, Date date) {
        this.id = id;
        this.friend = friend;
        this.meetingId = meetingId;
        this.status = status;
        this.self = self;
        this.seen = seen;
        this.date = date;
    }

    public MeetingDto(User friend, String meetingId, String status, Boolean self, Boolean seen, Date date) {
        this.friend = friend;
        this.meetingId = meetingId;
        this.status = status;
        this.self = self;
        this.seen = seen;
        this.date = date;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSelf() {
        return self;
    }

    public void setSelf(Boolean self) {
        this.self = self;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
