package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }


    public ApiResponse getAJob(Long id)
    {
        Optional<Job> optionalJob=jobRepository.findById(id);

        if(optionalJob.isPresent())
        {
            return new ApiResponse(200,"Job fetching successful",optionalJob.get());
        }
        return new ApiResponse(500,"Error fetching the job",null);
    }

    public List<Job> searchJobByField(String field){
        if(field.equalsIgnoreCase("all"))
            return jobRepository.findAll();
        else{
            return jobRepository.findByField(field);
        }

    }

    public ApiResponse postJob(JobDTO jobDTO)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user=userDaoRepository.findByEmail(currentPrincipalName);

        if(user!=null && user.getUserType().equalsIgnoreCase("employee") )
        {
            Job job=new Job();
            job.setDatePosted(new Date());
            job.setDescription(jobDTO.getDescription());
            job.setField(jobDTO.getField());
            job.setSalary(jobDTO.getSalary());
            job.setLattitude(jobDTO.getLattitude());
            job.setLongitude(jobDTO.getLongitude());
            job.setTitle(jobDTO.getTitle());
            job.setJobPosterId(user.getId());
            return new ApiResponse(200,"Job successfully posted",jobRepository.save(job));
        }

        return  new ApiResponse(500,"Something went wrong",null);
    }

}
