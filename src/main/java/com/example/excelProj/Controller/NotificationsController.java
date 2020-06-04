package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Repository.NotificationsRepository;
import com.example.excelProj.Service.NotificationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Rehan on 6/4/2020.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/notifications")
public class NotificationsController {

    @Autowired
    NotificationsRepository notificationsRepository;

    @Autowired
    NotificationSerivce notificationSerivce;

    @GetMapping("/company/{id}")
    public ApiResponse getNotificationsByCompanyId(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") int page) {

        return notificationSerivce.getNotificationsForCompany(id,page);
    }




    @GetMapping("/company/notifications_read/{companyId}")
    public ApiResponse markAllNoticationsRead(@PathVariable("companyId") Long id,@RequestParam(defaultValue = "0") int page) {

        Pageable pageable=  PageRequest.of(page,5);
        notificationsRepository.setAllNoticationsAsReadForCompany(id);
        return  new ApiResponse(200,"All notifications read",notificationSerivce.getNotificationsForCompany(id,page));
    }



    @GetMapping("/company/notification_marked")
    public ApiResponse markSelectNotificationAsRead(@RequestParam Map<String,String> requestParms) {

        Long companyId=Long.parseLong(requestParms.get("companyId"));
        Long jobId=Long.parseLong(requestParms.get("jobId"));
        Integer page = Integer.parseInt(requestParms.get("page"));
        notificationsRepository.setSelectedNotificationAsReadForCompany(companyId,jobId);
        Pageable pageable=  PageRequest.of(page,5);
        return  new ApiResponse(200,"All notifications read",notificationSerivce.getNotificationsForCompany(companyId,page));
    }


    @GetMapping("/company/notification_count/{companyId}")
    public Long getNotificationsCount(@PathVariable("companyId") Long id) {
        return notificationsRepository.getNotificationsCountForCompany(id);
    }



//    candidate notifications

    @GetMapping("/candiate/{id}")
    public ApiResponse getNotificationsByCandidateId(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") int page) {

        return notificationSerivce.getNotificationsForCandidate(id,page);
    }

}
