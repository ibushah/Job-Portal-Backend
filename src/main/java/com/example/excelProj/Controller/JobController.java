package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllJobsDTO;

import com.example.excelProj.Dto.JobDTO;
import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Model.ReviewAndRating;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.JobPaginationRepository;
import com.example.excelProj.Repository.JobRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import com.example.excelProj.Service.JobService;
import jdk.nashorn.internal.scripts.JO;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmCollectionIdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @Autowired
    UserDaoRepository userDaoRepository;

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


    @PutMapping("/update/{jobId}")
    public ApiResponse updateJob(@PathVariable("jobId") Long jobId,@RequestBody JobDTO jobDTO)
    {
        return jobService.updateJOB(jobId,jobDTO);
    }


    @GetMapping("/myJobs")
    public Page<Job> getMyJobs(@RequestParam(defaultValue ="0")int page)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userDaoRepository.findByEmail(currentPrincipalName);
        Long id = user.getCompanyProfile().getId();
        return jobRepository.findJobsByCompanyPaginated(id,PageRequest.of(page,5));

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

    @PostMapping("/applyJob")
    public ApiResponse<Job> applyJobDTOApiResponse(@RequestBody ReviewAndRatingDTO reviewAndRatingDTO){
        return  jobService.apply_on_job(reviewAndRatingDTO);
    }


    @GetMapping("/searchbycity")
    public Page<Job> findByCityName(@RequestParam Map<String,String> requestParms){

        String city = requestParms.get("city");
        int page  = Integer.parseInt(requestParms.get("page"));
        return  jobRepository.findByCity(city,PageRequest.of(page,5));
    }

    @GetMapping("/candidatescount/{jobId}")
    public ApiResponse findNumberOfCandidateApplied(@NotNull @Valid @PathVariable(name = "jobId") Long jobId){
        return jobService.getAppliedCandidateByJobId(jobId);
    }

    @GetMapping("/candidateprofiles/{jobId}")
    public ApiResponse showCandidateProfileAgainstJobId(@NotNull @Valid @PathVariable(name = "jobId") Long jobId){
        return jobService.getAppliedCandidateProfilesByJobId(jobId);
    }









}
