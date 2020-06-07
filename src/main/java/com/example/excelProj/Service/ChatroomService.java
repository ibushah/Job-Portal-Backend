package com.example.excelProj.Service;


import com.example.excelProj.Model.Chatroom;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.ChatroomRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatroomService {


    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    public Long initiateChat(Long to,Long from)
    {
       Optional<Chatroom> chatroom=Optional.of(chatroomRepository.findByUsers(from,to));

        if(chatroom.isPresent())
            return chatroom.get().getId();

       Optional<User> user1=userDaoRepository.findById(from);
        Optional<User> user2=userDaoRepository.findById(to);

        if(user1.isPresent() && user2.isPresent()) {
            Chatroom chatroom1 = new Chatroom(user1.get(), user2.get());
            Chatroom chatroom2 = chatroomRepository.save(chatroom1);
            return chatroom2.getId();
        }
        return null;
    }




}
