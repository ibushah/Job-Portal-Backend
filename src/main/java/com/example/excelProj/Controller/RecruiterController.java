package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.*;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.RecruiterJobs;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.AppliedForRecruiterJobRepository;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Repository.RecruiterJobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.RecruiterService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Rehan on 5/28/2020.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/recruiter/")
public class RecruiterController {




    @Autowired
    RecruiterJobRepository recruiterJobRepository;

    @Autowired
    RecruiterService recruiterService;


    @Autowired
    AppliedForRecruiterJobRepository appliedForRecruiterJobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;


    @Autowired
    CandidateProfileRepository candidateProfileRepository;


    @PostMapping("post/job")
    public ApiResponse postRecruiterJob(@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.postJob(recruiterProfileDTO);
    }

    @PutMapping("update/job/{jobId}")
    public ApiResponse updateRecruiterJob(@PathVariable("jobId") Long jobId,@RequestBody RecruiterJobsDTO recruiterProfileDTO){
        return recruiterService.updateJob(jobId,recruiterProfileDTO);
    }

    @GetMapping("get/job/{companyId}")
    public Page<RecruiterJobs> getAllJobsOfRecruiterUserId(@PathVariable("companyId") Long companyId, @RequestParam(defaultValue = "0")int page){

        org.springframework.data.domain.Pageable pageable = PageRequest.of(page,5);

         return  recruiterJobRepository.findAllJobsByRecruiterCompanyId(companyId,pageable);
    }

    @GetMapping("get/{jobId}")
    public ApiResponse getJobByJobId(@PathVariable("jobId") Long jobId){


        return  new ApiResponse(200,"Successfull",recruiterJobRepository.findById(jobId));
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        ModelMapper modelMapper = new ModelMapper();
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }


    @PostMapping("referJobToCandidate")
    public ApiResponse referRecruiterJobToCandidates(@RequestBody ReferJobToCandidateDTO referJobToCandidateDTO){
//        Long userId = Long.parseLong(requestParam.get("userId"));
//        Long jobId  = Long.parseLong(requestParam.get("jobId"));
//        Long candidateId = Long.parseLong(requestParam.get("candidateId"));

        return recruiterService.referJob(referJobToCandidateDTO);

    }


    @GetMapping("jobsbycategory")
    public Page<RecruiterJobs> getJobsByCategory(@RequestParam Map<String,String> requestParams){
        String category=requestParams.get("category");
        category = category.replaceAll("_and_","&");
        Integer page=Integer.parseInt(requestParams.get("page"));

        Pageable pageable = PageRequest.of(page,5);

        return recruiterJobRepository.findByCategory(category,pageable);
    }


    @GetMapping("privateJobAllDetails/{jobId}")
    public ApiResponse getAllInfoAgainstASingleJob(@PathVariable("jobId") Long jobId){
        return recruiterService.getAllInfoOfJobIdForRecruiter(jobId);
//        return  appliedForRecruiterJobRepository.getAllByCandidateProfile(jobId);
    }



    @GetMapping("privateJobDetailForCandidate/{jobId}")
    public ApiResponse detailsForCandidate(@PathVariable("jobId") Long jobId){
        return recruiterService.privateJobDetailsForCandidate(jobId);
    }


    @PostMapping("apply")
    public ApiResponse applyOnPrivateJob(@RequestBody ReferJobToCandidateDTO referJobToCandidateDTO){
        return recruiterService.applyOnJobByCandidate(referJobToCandidateDTO);
    }


    @DeleteMapping("delete/{jobId}/page")
    public ApiResponse deleteJobAndItsAssociations(@PathVariable(name = "jobId") Long jobId,@RequestParam(name = "page") int page){
        return  recruiterService.deleteJobById(jobId,PageRequest.of(page,5));
    }


    @GetMapping("search")
    public ApiResponse searchAllCandidates(@RequestParam("search") String searchString){



       List<User> foundUsers  =  userDaoRepository.searchUser(searchString) ;
       List<SearchUserDTO> searchUserDTOS = new ArrayList<>();

        for (User u:foundUsers) {

            SearchUserDTO userDTO = new SearchUserDTO();


            userDTO.setDp(null);
            userDTO.setProfileId(null);
            userDTO.setName(u.getName());
            userDTO.setUserId(u.getId());
            userDTO.setUserType(u.getUserType());

            if(u.getUserType().equalsIgnoreCase("candidate") && u.getCandidateProfile()!=null){


                userDTO.setDp(u.getCandidateProfile().getDp());
                userDTO.setProfileId(u.getCandidateProfile().getId());

            }
            else if(u.getCompanyProfile()!=null){

                userDTO.setDp(u.getCompanyProfile().getLogo());
                userDTO.setProfileId(u.getCompanyProfile().getId());
            }

            searchUserDTOS.add(userDTO);
        }
        return new ApiResponse(200,"Successfull",searchUserDTOS);
    }



    @GetMapping("notReferedJobs")
    public ApiResponse testingCalls(@RequestParam Map<String,String> requestParams){
        Long candId = Long.parseLong(requestParams.get("candId"));
        Long companyId = Long.parseLong(requestParams.get("companyId"));
        Integer page=Integer.parseInt(requestParams.get("page"));

        Pageable pageable = PageRequest.of(page,3);


        List<Long> idList = appliedForRecruiterJobRepository.getDetails(candId,companyId,pageable);
        List<RecruiterJobs> recruiterJobs = new ArrayList<>();
        for (Long id:idList) {
            Optional<RecruiterJobs> jobsOptional = recruiterJobRepository.findById(id);
            if(jobsOptional.isPresent()){
                recruiterJobs.add(jobsOptional.get()) ;
            }
        }
        return new ApiResponse(200,"Successfull",recruiterJobs);
    }




    @DeleteMapping("undoRefer/{jobId}/{candId}")
    public ApiResponse undoReferToCandidate(@PathVariable("jobId") Long jobId,@PathVariable("candId") Long candId){
//        Long userId = Long.parseLong(requestParam.get("userId"));
//        Long jobId  = Long.parseLong(requestParam.get("jobId"));
//        Long candidateId = Long.parseLong(requestParam.get("candidateId"));

        return recruiterService.undoRefered(jobId,candId);

    }






}


