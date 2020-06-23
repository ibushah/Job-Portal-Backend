package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.FriendDto;
import com.example.excelProj.Dto.SearchUserDTO;
import com.example.excelProj.Model.Friend;
import com.example.excelProj.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FriendController {



    @Autowired
    FriendService friendService;

    @PostMapping("/send-request")
    public ApiResponse sendRequest(@RequestBody FriendDto friendsIdDto) {
        return friendService.sendRequest(friendsIdDto);
    }


    @PostMapping("/accept-request")
    public ApiResponse acceptRequest(@RequestBody FriendDto friendsIdDto) {
        return friendService.acceptRequest(friendsIdDto);
    }

    @GetMapping("/get-all-requests/{id}")
    public List<SearchUserDTO> getAllRequests(@PathVariable("id")  Long userId) {
        return friendService.getAllRequests(userId);
    }

    @GetMapping("/remove-friend")
    public ApiResponse removeFriend(@RequestBody FriendDto friendsIdDto) {
        return friendService.removeFriend(friendsIdDto);
    }

    @PostMapping("/cancel-request")
    public ApiResponse cancelRequest(@RequestBody FriendDto friendsIdDto) {
        return friendService.removeFriend(friendsIdDto);
    }

    @GetMapping("/get-all-friends/{id}")
    public ResponseEntity getAllFriends(@PathVariable("id")  Long userId) {
        return friendService.getAllFriends(userId);
    }

    @PostMapping("/get-friendship-status")
    public ResponseEntity<String> getFriendshipStatus(@RequestBody FriendDto friendDto)
    {
        return friendService.getFriendshipStatus(friendDto);
    }
}

