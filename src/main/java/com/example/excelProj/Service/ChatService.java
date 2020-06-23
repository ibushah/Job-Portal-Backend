package com.example.excelProj.Service;

import com.example.excelProj.Model.Chat;
import com.example.excelProj.Model.Chatroom;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.ChatRepository;
import com.example.excelProj.Repository.ChatroomRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    UserDaoRepository userDaoRepository;


    public ResponseEntity<String> initiateChat(Long user1Id, Long user2Id) {
        Chatroom chatroom = chatroomRepository.findChatroom(user1Id, user2Id);

        if (chatroom == null) {
            String uuid = UUID.randomUUID().toString();
            Optional<User> user1 = userDaoRepository.findById(user1Id);
            Optional<User> user2 = userDaoRepository.findById(user2Id);

            if (user1.isPresent() && user2.isPresent()) {
                chatroomRepository.save(new Chatroom(user1.get(), user2.get(), uuid));
                chatroomRepository.save(new Chatroom(user2.get(), user1.get(), uuid));

                return new ResponseEntity<>("\""+uuid+"\"", HttpStatus.OK);

            }
            return new ResponseEntity<>("\"Chat users not found\"", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("\""+chatroom.getChatroomId()+"\"", HttpStatus.OK);
    }


    public ResponseEntity<List<Chat>>  getAllChats( String chatroomId){
       return new ResponseEntity(chatRepository.findAllChats(chatroomId),HttpStatus.OK);
    }
}
