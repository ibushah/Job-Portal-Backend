package com.example.excelProj.Controller;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.JobPostDTO;
import com.example.excelProj.Dto.TenderDTO;
import com.example.excelProj.Dto.ViewTenderDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.Tender;
import com.example.excelProj.Model.TenderAssortments;
import com.example.excelProj.Repository.TenderRepository;
import com.example.excelProj.Service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TenderController {

    @Autowired
    TenderRepository tenderRepository;

    @Autowired
    TenderService tenderService;

    @GetMapping("/tender/all")
    public ResponseEntity<List<Tender>> getAllTenders()
    {
       List<Tender> tenderList = tenderRepository.findAll();
        return new ResponseEntity<List<Tender>>(tenderList, HttpStatus.OK);
    }

   @PostMapping("/tender")
    public ResponseEntity<Tender> addTender(@Valid @NotNull @RequestBody TenderDTO tenderDTO){
        return tenderService.save(tenderDTO);
   }

    @GetMapping("/tender/{tenderId}")
    public ResponseEntity<ViewTenderDTO> findTender(@PathVariable("tenderId") Long tenderId){
        return tenderService.findTenderById(tenderId);
    }
    @GetMapping("/tendernotification/{recruiterId}")
    public ResponseEntity<List<TenderAssortments>> getTenderNotifications(@PathVariable("recruiterId") Long recruiterId){
       return tenderService.getTenderNotifications(recruiterId);
    }

    @GetMapping("/tendernotification/{recruiterId}")
    public ResponseEntity<ViewTenderDTO> getTenderNotifications(@PathVariable("recruiterId") Long recruiterId){
        return tenderService.getTenderNotifications(recruiterId);
    }




}