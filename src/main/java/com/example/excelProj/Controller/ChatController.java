package com.example.excelProj.Controller;

import com.example.excelProj.Dto.ChatDTO;
import com.example.excelProj.Model.Chat;
import com.example.excelProj.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    ChatService chatService;

    @MessageMapping("/chat/{to}/{chatroomId}")
    public void sendMessage(@DestinationVariable("to") String to,@DestinationVariable("chatroomId") String chatroomId, @Payload ChatDTO chatDTO) {
        simpMessagingTemplate.convertAndSend("/topic/chat/" + to, chatDTO);
      simpMessagingTemplate.convertAndSend("/topic/chatroom/"+chatroomId ,chatDTO);

    }

    @GetMapping("/initiate-chat")
    public ResponseEntity<String> initiateChat(@RequestParam("user1") Long user1,@RequestParam("user2") Long user2)
    {
       return chatService.initiateChat(user1,user2);
    }

    @GetMapping("/get-all-chats/{chatroomId}")
    public ResponseEntity<List<Chat>>  getAllChats(@PathVariable("chatroomId") String chatroomId){
        return chatService.getAllChats(chatroomId);
    }
}
