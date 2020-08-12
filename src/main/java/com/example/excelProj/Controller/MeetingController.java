package com.example.excelProj.Controller;


import com.example.excelProj.Dto.ChatDTO;
import com.example.excelProj.Dto.LocationDto;
import com.example.excelProj.Model.Chat;
import com.example.excelProj.Model.Location;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.LocationRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/meeting")
public class MeetingController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    MeetingService meetingService;





    @GetMapping("/invite")
    public ResponseEntity sendMeetingInvite(@RequestParam("userId") Long userId, @RequestParam("friendId") Long friendId) {
        return meetingService.sendMeetingInvite(userId, friendId);
    }


    @GetMapping("/cancel-invite")
    public ResponseEntity cancelMeetingInvite(@RequestParam("userId1") Long userId1,
                                              @RequestParam("userId2") Long userId2
            ,@RequestParam("meetingId") String meetingId) {
        return meetingService.cancelMeetingInvite(userId1,userId2,meetingId);
    }

    @GetMapping("/accept-invite")
    public ResponseEntity acceptMeetingInvite(@RequestParam("userId1") Long userId1,
                                              @RequestParam("userId2") Long userId2
            ,@RequestParam("meetingId") String meetingId) {
        return meetingService.acceptMeetingInvite(userId1,userId2,meetingId);

    }

    @GetMapping("/complete-invite")
    public ResponseEntity completeMeetingInvite(@RequestParam("userId1") Long userId1,
                                                @RequestParam("userId2") Long userId2
            ,@RequestParam("meetingId") String meetingId) {
        return meetingService.completeMeetingInvite(userId1,userId2,meetingId);
    }
    @GetMapping("/filter/{id}")
    public ResponseEntity getAllMeetingInvite(
                                              @RequestParam("filter") String filter, @PathVariable("id") Long userId) {
        return meetingService.getFilteredInvites(userId, filter);
    }



    @GetMapping("/room")
    public ResponseEntity getMeetingRoom(@RequestParam("meetingId") String meetingId,
                                          @RequestParam("userId") Long userId)
    {
        return meetingService.getMeetingRoom(meetingId, userId);
    }


    @GetMapping("/notifications/{userId}")
    public ResponseEntity getMeetingNotificationCount(@PathVariable("userId") Long userId)
    {
        return meetingService.getMeetingNotificationCount(userId);
    }

    @MessageMapping("/location/{userId}/{meetingId}")
    public void sendMessage(@DestinationVariable("userId") Long userId, @DestinationVariable("meetingId") String meetingId,
                            @Payload LocationDto locationDto) {


        simpMessagingTemplate.convertAndSend("/topic/location/" + meetingId, locationDto);

        Optional<User> user = userDaoRepository.findById(userId);
        Location location=locationRepository.findLocationByUserId(userId);
        if (user.isPresent()) {
            if(location!=null)
            locationRepository.setLongitudeAndLatitude(userId, locationDto.getLongitude(), locationDto.getLatitude());
            else
                locationRepository.save(new Location(locationDto.getLongitude(),locationDto.getLatitude(),user.get()));
        }

    }



}
