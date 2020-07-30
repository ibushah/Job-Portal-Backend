package com.example.excelProj.Controller;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.AllCompaniesWithReviewDTO;
import com.example.excelProj.Dto.ReviewAndRatingDTO;
import com.example.excelProj.Model.Job;
import com.example.excelProj.Repository.ReviewAndRatingRepository;
import com.example.excelProj.Service.JobService;
import com.example.excelProj.Service.ReviewAndRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Path;
import javax.validation.Valid;
import java.io.IOException;
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
    public ApiResponse getRatingAgainstCompanyId(@RequestParam(defaultValue = "0") Long companyId){
        return reviewAndRatingService.getAverageRating(companyId);
    }

    @PostMapping("/comment")
    public ApiResponse applyJobDTOApiResponse(@RequestParam(required = false,name = "video") MultipartFile videoFile,
                                               ReviewAndRatingDTO reviewAndRatingDTO){
        if(reviewAndRatingDTO.getType().equalsIgnoreCase("video"))
            reviewAndRatingDTO.setVideo(videoFile);
        return  reviewAndRatingService.saveRatingAndReview(reviewAndRatingDTO);
    }

//    @GetMapping("/allcompanies/{candidateId}")
//    public List<AllCompaniesWithReviewDTO> allCompaniesWithReviewDTOS(@PathVariable(name = "candidateId") Long candidateId){
//        return reviewAndRatingRepository.getAllCompaniesWithReviews(candidateId,"employee");
//    }

        @PostMapping("/reivewAgainstCandidate")
    public ApiResponse saveComment(@RequestParam(required = false,name = "video") MultipartFile videoFile, ReviewAndRatingDTO reviewAndRatingDTO){
            if(reviewAndRatingDTO.getType().equalsIgnoreCase("video"))
                reviewAndRatingDTO.setVideo(videoFile);
        return reviewAndRatingService.saveReviewAgainstCandidate(reviewAndRatingDTO)   ;
}


    @GetMapping("/{user}/{filename:.+}")
    public ResponseEntity<InputStreamResource> getGalleryImage(@PathVariable("user") String userIdAndName, @PathVariable("filename") String filename)
            throws IOException {
        return reviewAndRatingService.getImage(filename,userIdAndName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(@PathVariable("id") Long id){

        return reviewAndRatingService.deleteReview(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReview(@PathVariable("id") Long id, @RequestParam(required = false,name = "video") MultipartFile videoFile, ReviewAndRatingDTO reviewAndRatingDTO)
    {
        if(reviewAndRatingDTO.getType().equalsIgnoreCase("video"))
            reviewAndRatingDTO.setVideo(videoFile);
        return reviewAndRatingService.updateReview(id,reviewAndRatingDTO);
    }

}
