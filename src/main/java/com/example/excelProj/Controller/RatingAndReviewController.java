package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Service.JobService;
import com.example.excelProj.Service.ReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Rehan on 3/27/2020.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/review")
public class RatingAndReviewController {

    @Autowired
    ReviewAndRatingService reviewAndRatingService;

    @Autowired
    JobService jobService;


    @GetMapping("/averageRating")
    public ApiResponse getRatingAgainstCompanyId(@RequestParam(defaultValue = "0") Long companyId){
        return reviewAndRatingService.getAverageRating(companyId);
    }

    @PostMapping("/comment")
    public ApiResponse applyJobDTOApiResponse(@RequestBody ReviewAndRatingDTO reviewAndRatingDTO){
        return  reviewAndRatingService.saveRatingAndReview(reviewAndRatingDTO);
    }

}
