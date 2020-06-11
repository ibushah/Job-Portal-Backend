package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Dto.TestNotificationsDTO;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.openmbean.OpenDataException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by Rehan on 6/4/2020.
 */

@Service
public class NotificationSerivce {

    @Autowired
    NotificationsRepository notificationsRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    JobPaginationRepository jobPaginationRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;


    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;

    @Autowired
    AppliedForRepository appliedForRepository;


    @Autowired
    CompanyProfileRepository companyProfileRepository;



    public ApiResponse getNotificationsForCompany(Long companyId,Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 5);
        List<NotificationDTO> notificationsForCompany = new ArrayList<>();

        Page<TestNotificationsDTO> notificationsDTOS = notificationsRepository.getNotifications(companyId, pageable);

        for (TestNotificationsDTO t:notificationsDTOS) {


            Optional<CandidateProfile> candidateProfile = candidateProfileRepository.findById(t.getCandidateId());
            Optional<Job> job = jobPaginationRepository.findById(t.getJobId());

            Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(t.getCompanyId());
            NotificationDTO notificationDTO  = new NotificationDTO();
            notificationDTO.setCandidate(candidateProfile.get().getUser().getName());
            notificationDTO.setCandidateDp(candidateProfile.get().getDp());
            notificationDTO.setDate(t.getNotificationDate());
            notificationDTO.setJobTitle(job.get().getTitle());
            notificationDTO.setNotified(t.getSeen());
            notificationDTO.setJobId(t.getJobId());
            notificationsForCompany.add(notificationDTO);

        }

        return new ApiResponse(200,"Successfull",notificationsForCompany);
    }



    public ApiResponse getNotificationsForCandidate(Long candidateId,Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 5);
        List<NotificationDTO> notificationsForCompany = new ArrayList<>();

        Page<TestNotificationsDTO> notificationsDTOS = notificationsRepository.getNotificationsForCandidate(candidateId, pageable);

        for (TestNotificationsDTO t:notificationsDTOS) {


            Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(t.getCompanyId());
            Optional<RecruiterJobs> job = recruiterJobRepository.findById(t.getJobId());

            NotificationDTO notificationDTO  = new NotificationDTO();
            notificationDTO.setCandidate(companyProfile.get().getUser().getName());
            notificationDTO.setCandidateDp(companyProfile.get().getLogo());
            notificationDTO.setDate(t.getNotificationDate());
            notificationDTO.setJobTitle(job.get().getTitle());
            notificationDTO.setNotified(t.getSeen());
            notificationDTO.setJobId(t.getJobId());
            notificationsForCompany.add(notificationDTO);

        }

        return new ApiResponse(200,"Successfull",notificationsForCompany);
    }

    public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
        ModelMapper modelMapper = new ModelMapper();
        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
    }
}

