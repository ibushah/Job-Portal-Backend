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
            meetingRoom1.setDate(new Date());
            meetingRoom1.setMeetingId(uuid);
            meetingRoom1.setStatus("pending");
            meetingRoom1.setSelf(false);
            meetingRoom1.setSeen(false);
            meetingRoom1.setUser1(user2.get());
            meetingRoom1.setUser2(user1.get());

            List<MeetingRoom> list = new ArrayList<>();
            list.add(meetingRoom);
            list.add(meetingRoom1);
            meetingRoomRepository.saveAll(list);

            return new ResponseEntity("\"Meeting invite  sent\"", HttpStatus.OK);


        }
        return new ResponseEntity("\"Meeting invite not sent\"", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity cancelMeetingInvite(String meetingId) {
        meetingRoomRepository.cancelMeetingInvite(meetingId);
        return new ResponseEntity("\"Meeting invite cancelled\"", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity acceptMeetingInvite(String meetingId) {
        meetingRoomRepository.acceptMeetingInvite(meetingId);
        return new ResponseEntity("\"Meeting invite accepted\"", HttpStatus.NOT_FOUND);
    }


    public ResponseEntity getFilteredInvites(Long userId, String filter) {

        meetingRoomRepository.seenAllMeetings(userId);

        if (filter.equalsIgnoreCase("all")) {
            return new ResponseEntity(meetingRoomRepository.findAllMeetings(userId), HttpStatus.OK);
        }

        return new ResponseEntity(meetingRoomRepository.filteredMeetings(userId, filter), HttpStatus.OK);
    }


}
