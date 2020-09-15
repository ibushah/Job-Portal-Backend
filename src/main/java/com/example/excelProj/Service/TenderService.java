package com.example.excelProj.Service;

import com.example.excelProj.Dto.TenderDTO;
import com.example.excelProj.Model.Tender;
import com.example.excelProj.Repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TenderService {

    @Autowired
    TenderRepository tenderRepository;

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
                tenderRepository.save(tender);
            }
            return new ResponseEntity<Tender>(tender!=null?tender:null,HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Tender>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Tender> findByUserId(Long userId) {
        try {
            Optional<Tender> tenderOption = tenderRepository.findById(userId);
            return new ResponseEntity<Tender>(tenderOption.get(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<Tender>(HttpStatus.NOT_FOUND);
        }
    }

}
