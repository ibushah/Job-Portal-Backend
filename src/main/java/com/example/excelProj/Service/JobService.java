package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.JobPaginationRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    JobPaginationRepository jobPaginationRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

//    Paginated jobs


    public Page<Job> getPaginatedJobs(int pageNumber){
        Pageable firstPageWithTenElements = PageRequest.of(pageNumber, 10);
        return jobPaginationRepository.findAll(firstPageWithTenElements);
    }


    public ApiResponse getAJob(Long id) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {
            return new ApiResponse(200, "Job fetching successful", optionalJob.get());
        }
        return new ApiResponse(500, "Error fetching the job", null);
    }

//    public List<Job> searchJobByField(String field){
//        if(field.equalsIgnoreCase("all"))
//            return jobRepository.findAll();
//        else{
//            return jobRepository.findByField(field);
//        }
//
//    }

    public ApiResponse postJob(JobDTO jobDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);


        if (user != null && user.getUserType().equalsIgnoreCase("employee") && user.getCompanyProfile() != null) {

            Job job = new Job();

            job.setDescription(jobDTO.getDescription());
            job.setSalary(jobDTO.getSalary());
            job.setLatitude(jobDTO.getLatitude());
            job.setLongitude(jobDTO.getLongitude());
            job.setTitle(jobDTO.getTitle());
            job.setCity(jobDTO.getCity());
            job.setCountry(jobDTO.getCountry());
            job.setProvince(jobDTO.getProvince());
            job.setCategory(jobDTO.getCategory());
            job.setType(jobDTO.getType());
            job.setPublishFrom(jobDTO.getPublishFrom());
            job.setPublishTo(jobDTO.getPublishTo());
            job.setCompanyProfile(user.getCompanyProfile());
            return new ApiResponse(200, "Job successfully posted", jobRepository.save(job));
        }

        return new ApiResponse(500, "Something went wrong", null);
    }


    public ApiResponse<Job> getMyJobs(Long employeeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);

        if (user != null && user.getUserType().equalsIgnoreCase("employee") && user.getCompanyProfile() != null) {

                List<Job> jobList = jobRepository.findByEmployeeId(employeeId);
                return  new ApiResponse(200,"Successfull",jobList);

        }
        else{
            return new ApiResponse(500, "Something went wrong", null);
        }
    }


}

