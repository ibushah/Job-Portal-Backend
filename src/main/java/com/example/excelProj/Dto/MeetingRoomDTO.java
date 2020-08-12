package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

import java.io.Serializable;

public class MeetingRoomDTO implements Serializable {

    String meetingId;
    User user1;
    User user2;


    public MeetingRoomDTO(String meetingId, User user1, User user2) {
        this.meetingId = meetingId;
        this.user1 = user1;
        this.user2 = user2;
    }

    public MeetingRoomDTO() {
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
