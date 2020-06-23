package com.example.excelProj.Repository;

import com.example.excelProj.Model.Chat;
import com.example.excelProj.Model.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {

    @Query(value = "select * from chat where chatroom_id=:chatroomId",nativeQuery = true)
    List<Chat> findAllChats(@Param("chatroomId") String chatroomId);
}
