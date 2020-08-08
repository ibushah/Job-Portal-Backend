package com.example.excelProj.Repository;

import com.example.excelProj.Dto.MeetingDto;
import com.example.excelProj.Model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query("select new com.example.excelProj.Dto.MeetingDto(m.id,u,m.meetingId,m.status,m.self,m.seen,m.date)" +
            " from User u join MeetingRoom m on m.user1.id=:id")
    List<MeetingDto> findAllMeetings(@Param("id") Long id);

    @Query("select new com.example.excelProj.Dto.MeetingDto(m.id,m.user2,m.meetingId,m.status,m.self,m.seen,m.date)" +
            " from User u join MeetingRoom m on m.user1.id=:id where m.status=:filter")
    List<MeetingDto> filteredMeetings(@Param("id") Long id, @Param("filter") String filter);

    @Query(value = "update meeting_room set status='accepted' where meeting_id=:meetingId", nativeQuery = true)
    void acceptMeetingInvite(@Param("meetingId") String meetingId);

    @Query(value = "update meeting_room set status='cancelled' where meeting_id=:meetingId", nativeQuery = true)
    void cancelMeetingInvite(@Param("meetingId") String meetingId);

    @Query(value = "update meeting_room set seen=true where user1_id=:id", nativeQuery = true)
    void seenAllMeetings(@Param("id") Long id);
}
