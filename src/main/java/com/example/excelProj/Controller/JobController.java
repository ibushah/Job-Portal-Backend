package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllJobsDTO;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Repository.JobPaginationRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    JobService jobService;


    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobPaginationRepository jobPaginationRepository;

    @GetMapping("/all")
    public List<Job> getAllJobs()
    {
        return jobRepository.findAll();
    }

    @GetMapping("/")
    public ApiResponse<Job> getJobById(@RequestParam(defaultValue = "1") Long id)
    {
        return jobService.getAJob(id);
    }

    @GetMapping("/company")
    public List<Job> getJobsByCompany(@RequestParam(defaultValue = "1") Long id)
    {

        return jobService.getJobsByCompany(id);
    }

//    @GetMapping("/{field}")
//    public List<Job> getJobsByField(@PathVariable("field") String field)
//    {
//        return jobService.searchJobByField(field);
//    }

    @PostMapping("/")
    public ApiResponse postJob(@RequestBody JobDTO jobDTO)
    {
        return jobService.postJob(jobDTO);
    }

    @GetMapping("/myJobs/{id}")
    public ApiResponse<Job> getMyJobs(@PathVariable("id") Long id)
    {
        return jobService.getMyJobs(id);

    }

    @GetMapping("/paginatedjobs")
    public Page<AllJobsDTO> getAllPaginatedJobs(@RequestParam(defaultValue = "0") int page)
    {
        return jobRepository.joinAllJobs(PageRequest.of(page,5));
    }

    @GetMapping("/jobsbycategory")
    public Page<Job> getJobsByCategory(@RequestParam Map<String,String> requestParams){
        String category=requestParams.get("category");
        category = category.replaceAll("_and_","&");
        Integer page=Integer.parseInt(requestParams.get("page"));
        return jobRepository.findByCategory(category,PageRequest.of(page,5));
    }



}
