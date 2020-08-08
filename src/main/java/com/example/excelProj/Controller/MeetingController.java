package com.example.excelProj.Controller;


import com.example.excelProj.Dto.ChatDTO;
import com.example.excelProj.Dto.LocationDto;
import com.example.excelProj.Model.Chat;
import com.example.excelProj.Model.Location;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.LocationRepository;
import com.example.excelProj.Repository.UserDaoRepository;
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


    @GetMapping("/invite")
    public ResponseEntity sendMeetingInvite(@RequestParam("userId") Long userId,@RequestParam("friendId") Long friendId ){

    }


    @GetMapping("/cancel-invite")
    public ResponseEntity cancelMeetingInvite(@RequestParam("userId") Long userId,@RequestParam("friendId") Long friendId ){

    }

    @GetMapping("/accept-invite")
    public ResponseEntity cancelMeetingInvite(@RequestParam("userId") Long userId,@RequestParam("friendId") Long friendId ){

    }

    @GetMapping("/filter/{id}")
    public ResponseEntity getAllMeetingInvite(@RequestParam("filter") String filter,@PathVariable("id") Long userId ){

    }




    @MessageMapping("/location/{meetingId}")
    public void sendMessage(@DestinationVariable("userId") Long userId, @DestinationVariable("meetingId") String meetingId,
                            @Payload LocationDto locationDto) {


        simpMessagingTemplate.convertAndSend("/topic/location/" + meetingId, locationDto);

       Optional<User> user=userDaoRepository.findById(userId);
        if(user.isPresent())
        locationRepository.save(new Location(locationDto.getLongitude(),locationDto.getLatitude(),user.get()));

    }
}
