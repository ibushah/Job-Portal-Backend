package com.example.excelProj.Repository;

import com.example.excelProj.Dto.MeetingDto;
import com.example.excelProj.Model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query("select new com.example.excelProj.Dto.MeetingDto(m.id,m.user2,m.meetingId,m.status,m.self,m.seen,m.date)" +
            " from User u join MeetingRoom m on m.user1.id=u.id where m.user1.id=:id")
    List<MeetingDto> findAllMeetings(@Param("id") Long id);

    @Query("select new com.example.excelProj.Dto.MeetingDto(m.id,m.user2,m.meetingId,m.status,m.self,m.seen,m.date)" +
            " from User u join MeetingRoom m on m.user1.id=u.id where m.status=:filter and  m.user1.id=:id")
    List<MeetingDto> filteredMeetings(@Param("id") Long id, @Param("filter") String filter);

    @Query("select new com.example.excelProj.Dto.MeetingDto(m.id,m.user2,m.meetingId,m.status,m.self,m.seen,m.date)" +
            " from User u join MeetingRoom m on m.user1.id=u.id where m.status=:filter and m.self=:my and  m.user1.id=:id ")
    List<MeetingDto> filteredMeetingsWithSelf(@Param("id") Long id, @Param("filter") String filter, @Param("my") Boolean my);

    @Transactional
    @Modifying
    @Query(value = "update meeting_room set status='accepted' where meeting_id=:meetingId", nativeQuery = true)
    void acceptMeetingInvite(@Param("meetingId") String meetingId);

    @Transactional
    @Modifying
    @Query(value = "update meeting_room set status='cancelled' where meeting_id=:meetingId", nativeQuery = true)
    void cancelMeetingInvite(@Param("meetingId") String meetingId);

    @Transactional
    @Modifying
    @Query(value = "update meeting_room set status='completed' where meeting_id=:meetingId", nativeQuery = true)
    void completeMeetingInvite(@Param("meetingId") String meetingId);

    @Transactional
    @Modifying
    @Query(value = "update meeting_room set seen=true where user1_id=:id", nativeQuery = true)
    void seenAllMeetings(@Param("id") Long id);


    @Query(value = "select * from meeting_room where meeting_id=:meetingId and user1_id=:userId order by date desc", nativeQuery = true)
    MeetingRoom findByMeetingId(@Param("meetingId") String meetingId, @Param("userId") Long userId);


    @Query(value = "select count(*) from meeting_room where seen<>true and self<>true and user1_id=:userId",nativeQuery = true)
    Long findMeetingCount(@Param("userId") Long userId);

    @Query(value ="select * from meeting_room where meeting_id=:meetingId and user1_id=:userId" ,nativeQuery = true)
    MeetingRoom findMeetingRoomByUserId(@Param("meetingId") String meetingId, @Param("userId") Long userId);
}
