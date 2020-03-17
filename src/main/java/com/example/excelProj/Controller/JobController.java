package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    JobService jobService;


    @GetMapping("/all")
    public List<Job> getAllJobs()
    {
        return jobService.getAllJobs();
    }

    @GetMapping("/{field}")
    public List<Job> getJobsByField(@PathVariable("field") String field)
    {
        return jobService.searchJobByField(field);
    }

    @PostMapping("/")
    public ApiResponse postJob(@RequestBody JobDTO jobDTO)
    {
        return jobService.postJob(jobDTO);
    }
}
