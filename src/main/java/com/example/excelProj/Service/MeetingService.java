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
            meetingRoom.setStatus("approval");
            meetingRoom.setSelf(true);
            meetingRoom.setSeen(true);
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


    public ResponseEntity cancelMeetingInvite(Long user1Id,Long user2Id,String meetingId) {
//        meetingRoomRepository.cancelMeetingInvite(meetingId);
        MeetingRoom meetingRoom=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user1Id);
        MeetingRoom meetingRoom1=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user2Id);

        if(meetingRoom!=null && meetingRoom1!=null){
            meetingRoom.setStatus("cancelled");
            meetingRoom.setSeen(true);
            meetingRoom.setSelf(true);

            meetingRoom1.setStatus("cancelled");
            meetingRoom1.setSeen(false);
            meetingRoom1.setSelf(false);
            meetingRoomRepository.save(meetingRoom);
            meetingRoomRepository.save(meetingRoom1);
            return new ResponseEntity("\"Meeting invite cancelled\"", HttpStatus.OK);
        }
        return new ResponseEntity("\"Meeting invite not cancelled\"", HttpStatus.NOT_FOUND);

    }


    public ResponseEntity acceptMeetingInvite(Long user1Id,Long user2Id,String meetingId) {
//        meetingRoomRepository.acceptMeetingInvite(meetingId);

        //user1 is the person who accepted the meeting invite
        MeetingRoom meetingRoom=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user1Id);
        MeetingRoom meetingRoom1=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user2Id);

        if(meetingRoom!=null && meetingRoom1!=null){
            meetingRoom.setStatus("accepted");
            meetingRoom.setSeen(true);
            meetingRoom.setSelf(true);

            meetingRoom1.setStatus("accepted");
            meetingRoom1.setSeen(false);
            meetingRoom1.setSelf(false);
            meetingRoomRepository.save(meetingRoom);
            meetingRoomRepository.save(meetingRoom1);
            return new ResponseEntity("\"Meeting invite accepted\"", HttpStatus.OK);
        }
        return new ResponseEntity("\"Meeting invite not accepted\"", HttpStatus.NOT_FOUND);
    }
    public ResponseEntity completeMeetingInvite(Long user1Id,Long user2Id,String meetingId) {
//        meetingRoomRepository.completeMeetingInvite(meetingId);

        MeetingRoom meetingRoom=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user1Id);
        MeetingRoom meetingRoom1=meetingRoomRepository.findMeetingRoomByUserId(meetingId,user2Id);

        if(meetingRoom!=null && meetingRoom1!=null){
            meetingRoom.setStatus("completed");
            meetingRoom.setSeen(true);
            meetingRoom.setSelf(true);

            meetingRoom1.setStatus("completed");
            meetingRoom1.setSeen(false);
            meetingRoom1.setSelf(false);
            meetingRoomRepository.save(meetingRoom);
            meetingRoomRepository.save(meetingRoom1);
            return new ResponseEntity("\"Meeting invite completed\"", HttpStatus.OK);
        }
        return new ResponseEntity("\"Meeting invite not completed\"", HttpStatus.NOT_FOUND);
//        return new ResponseEntity("\"Meeting invite completed\"", HttpStatus.OK);
    }


    public ResponseEntity getFilteredInvites(Long userId, String filter) {

        meetingRoomRepository.seenAllMeetings(userId);

        if (filter.equalsIgnoreCase("all")) {
            return new ResponseEntity(meetingRoomRepository.findAllMeetings(userId), HttpStatus.OK);
        }


        return new ResponseEntity(meetingRoomRepository.filteredMeetings(userId, filter), HttpStatus.OK);
    }


    public ResponseEntity getMeetingRoom(String meetingId,Long userId)
    {
        MeetingRoom meetingRoom=meetingRoomRepository.findByMeetingId(meetingId,userId);
        if(meetingRoom!=null && meetingRoom.getStatus().equalsIgnoreCase("accepted"))
            return new ResponseEntity(meetingRoom,HttpStatus.OK);
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity getMeetingNotificationCount(Long userId){
        return new ResponseEntity(meetingRoomRepository.findMeetingCount(userId),HttpStatus.OK);
    }


}
