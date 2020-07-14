package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllCompaniesWithReviewDTO;
import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Repository.ReviewAndRatingRepository;
import com.example.excelProj.Service.JobService;
import com.example.excelProj.Service.ReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

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

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;



    @GetMapping("/averageRating")
    public ApiResponse getRatingAgainstCompanyId(@RequestParam(defaultValue = "0") Long companyId,
                                                 @RequestParam("video") MultipartFile videoFile){
        return reviewAndRatingService.getAverageRating(companyId);
    }

    @PostMapping("/comment")
    public ApiResponse applyJobDTOApiResponse(@RequestBody ReviewAndRatingDTO reviewAndRatingDTO){
        return  reviewAndRatingService.saveRatingAndReview(reviewAndRatingDTO);
    }

//    @GetMapping("/allcompanies/{candidateId}")
//    public List<AllCompaniesWithReviewDTO> allCompaniesWithReviewDTOS(@PathVariable(name = "candidateId") Long candidateId){
//        return reviewAndRatingRepository.getAllCompaniesWithReviews(candidateId,"employee");
//    }

        @PostMapping("/reivewAgainstCandidate")
    public ApiResponse saveComment(@RequestBody ReviewAndRatingDTO reviewAndRatingDTO){
        return reviewAndRatingService.saveReviewAgainstCandidate(reviewAndRatingDTO)   ;
}

}
