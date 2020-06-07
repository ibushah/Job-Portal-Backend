package com.example.excelProj.Controller;

import com.example.excelProj.Model.Chat;
import com.example.excelProj.Model.Chatroom;
import com.example.excelProj.Service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ChatroomController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    ChatroomService chatroomService;

    @GetMapping("/initiate-chat")
    public Long initiateChat(@RequestParam("from") Long from, @RequestParam("to") Long to) {
        return chatroomService.initiateChat(from, to);
    }





    @MessageMapping("/chat/{chatroomId}")
    @SendTo("/topic/chat")
    public void sendMessage(@Payload String message) {
        simpMessagingTemplate.convertAndSend("/topic/chat",message);
    }
}
