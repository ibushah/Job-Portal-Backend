package com.example.excelProj.Service;


import com.example.excelProj.Model.MeetingRoom;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.MeetingRoomRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeetingService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    public ResponseEntity sendMeetingInvite(Long userId, Long friendId) {

        Optional<User> user1 = userDaoRepository.findById(userId);
        Optional<User> user2 = userDaoRepository.findById(friendId);

        if (user1.isPresent() && user2.isPresent()) {
            String uuid = UUID.randomUUID().toString();
            MeetingRoom meetingRoom = new MeetingRoom();
            meetingRoom.setDate(new Date());
            meetingRoom.setMeetingId(uuid);
            meetingRoom.setStatus("pending");
            meetingRoom.setSelf(true);
            meetingRoom.setSeen(false);
            meetingRoom.setUser1(user1.get());
            meetingRoom.setUser2(user2.get());

            //meetingRoom for friend
            MeetingRoom meetingRoom1 = new MeetingRoom();
            meetingRoom.setDate(new Date());
            meetingRoom.setMeetingId(uuid);
            meetingRoom.setStatus("pending");
            meetingRoom.setSelf(false);
            meetingRoom.setSeen(false);
            meetingRoom.setUser1(user2.get());
            meetingRoom.setUser2(user1.get());

            List<MeetingRoom> list = new ArrayList<>();
            list.add(meetingRoom);
            list.add(meetingRoom1);
            meetingRoomRepository.saveAll(list);

            return new ResponseEntity("Meeting invite sent",HttpStatus.OK);


        }
        return new ResponseEntity("Meeting invite not sent",HttpStatus.NOT_FOUND);
    }


    public ResponseEntity cancelMeetingInvite(Long userId,Long friendId,String meetingId) {

    }


    public ResponseEntity cancelMeetingInvite(Long userId, Long friendId) {

    }


    public ResponseEntity getAllMeetingInvite(Long userId) {

        meetingRoomRepository.seenAllInvites(userId);
        meetingRoomRepository.findAllInvites(userId);
    }


    public ResponseEntity getAllAcceptedInvites(Long userId) {
        meetingRoomRepository.filteredMeetings(userId,"accepted");
    }


    public ResponseEntity getAllPendingInvites(Long userId) {
        meetingRoomRepository.filteredMeetings(userId,"pending");
    }



}
