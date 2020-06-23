package com.example.excelProj.Repository;

import com.example.excelProj.Model.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository<Chatroom,Long> {


    @Query(value = "select * from chatroom where user1_id=:user1 And user2_id=:user2",nativeQuery = true)
    Chatroom findChatroom(@Param("user1") Long user1, @Param("user2") Long user2);
}
