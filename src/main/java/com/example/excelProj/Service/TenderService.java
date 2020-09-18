package com.example.excelProj.Service;

import com.example.excelProj.Dto.TenderDTO;
import com.example.excelProj.Model.Tender;
import com.example.excelProj.Model.TenderAssortments;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.TenderAssortmentRepository;
import com.example.excelProj.Repository.TenderRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TenderService {

    @Autowired
    TenderRepository tenderRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    TenderAssortmentRepository tenderAssortmentRepository;

    public ResponseEntity<Tender> save(TenderDTO tenderDTO) {
        try {
            Tender tender = new Tender();
            if(tenderDTO!=null){
                tender.setRole(tenderDTO.getRole());
                tender.setAddress(tenderDTO.getAddress());
                tender.setCategory(tenderDTO.getCategory());
                tender.setCity(tenderDTO.getCity());
                tender.setCountry(tenderDTO.getCountry());
                tender.setActive(true);

                tender.setDescription(tenderDTO.getDescription());
                tender.setInterviewStartDate(tenderDTO.getInterviewStartDate());
                tender.setInterviewEndDate(tenderDTO.getInterviewEndDate());
                tender.setInterviewTimings(tenderDTO.getInterviewTimings());
                tender.setLatitude(tenderDTO.getLatitude());
                tender.setLongitude(tenderDTO.getLongitude());
                tender.setSalary(tenderDTO.getSalary());
                tender.setType(tenderDTO.getType());
                tender.setTenderPoster(userDaoRepository.findById(tenderDTO.getEmployerUserId()).get());
                tenderRepository.save(tender);
                postTenderNotification(tender,tenderDTO,"employer","recruiter");
                return new ResponseEntity<Tender>(tender != null ? tender : null, HttpStatus.OK);
            }
        }
        catch (Exception e){
            return  new ResponseEntity<Tender>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<Tender>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Tender> findTenderById(Long tenderId) {
        try {
            Optional<Tender> tenderOption = tenderRepository.findById(tenderId);
            return new ResponseEntity<Tender>(tenderOption.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Tender>(HttpStatus.NOT_FOUND);
        }
    }

    protected void postTenderNotification(Tender tender,TenderDTO tenderDTO,String notificationFrom,String notificationFor){
        //                notifciation work;
        TenderAssortments tenderAssortments = new TenderAssortments();
        User employerUser = userDaoRepository.findById(tenderDTO.getEmployerUserId()).get();
        User recruiterUser = userDaoRepository.findById(tenderDTO.getRecruiterUserId()).get();
        Tender tender1 = tenderRepository.findById(tender.getId()).get();

        if(employerUser!=null && recruiterUser!=null && tender1!=null){

            tenderAssortments.setEmployer(employerUser);
            tenderAssortments.setRecruiter(recruiterUser);
            tenderAssortments.setTender(tender);
            tenderAssortments.setNotificationDate(new Date());
            tenderAssortments.setNotifcationFrom(notificationFrom);
            tenderAssortments.setNotificationFor(notificationFor);
            tenderAssortments.setSeen(false);
            tenderAssortments.setApplied(false);
            tenderAssortmentRepository.save(tenderAssortments);
        }
    }

    public ResponseEntity<List<TenderAssortments>> getTenderNotifications(Long recruiterId ){
        List<TenderAssortments> listOfNotifications =tenderAssortmentRepository.getTenderNotifications(recruiterId);
        return new ResponseEntity<List<TenderAssortments>>(listOfNotifications, HttpStatus.OK);
    }
}
