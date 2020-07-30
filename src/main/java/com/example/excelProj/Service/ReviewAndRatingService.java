package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Commons.Constants;
import com.example.excelProj.Dto.*;
import com.example.excelProj.Model.*;
import com.example.excelProj.Repository.*;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewAndRatingService {

    @Autowired
    ReviewAndRatingRepository reviewAndRatingRepository;

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    @Autowired
    CompanyProfileRepository companyProfileRepository;

    @Value("${review.video.url}")
    String reviewVideoUrl;

    public ApiResponse getAverageRating(Long companyId) {
        Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(companyId);
        if (companyProfile.isPresent()) {
//            here get average rating
            Double averageRating = reviewAndRatingRepository.getAverageRatingByCompanyProfileId(companyId, "candidate");
            return new ApiResponse(200, "Average rating", averageRating);
        }
        return new ApiResponse(500, "Something went wrong", null);
    }

    public ApiResponse saveRatingAndReview(ReviewAndRatingDTO reviewAndRatingDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        Optional<CompanyProfile> companyUser = companyProfileRepository.findById(reviewAndRatingDTO.getCompanyId());
        reviewAndRatingDTO.setCandidateId(user.getCandidateProfile().getId());

        String userType = user.getUserType();
        Long companyId = reviewAndRatingDTO.getCompanyId();

        Optional<ReviewAndRating> reviewAndRatingObject = reviewAndRatingRepository.findByCandidateIdAndCompanyProfileIdAndAndRateBy(reviewAndRatingDTO.getCandidateId(), companyId, "candidate");
        if (reviewAndRatingObject.isPresent()) {
            return new ApiResponse(HttpStatus.ALREADY_REPORTED.value(), "Already rated", reviewAndRatingObject.get().getRating());

        } else if (reviewAndRatingDTO.getType().equalsIgnoreCase("video")) {

            //video type save
            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            if (saveVideoReview(reviewAndRatingDTO.getVideo(), companyUser.get().getUser().getName(),
                    companyUser.get().getUser().getId(), unique)) {

                ReviewAndRating reviewAndRating = new ReviewAndRating();
                reviewAndRating.setType(reviewAndRatingDTO.getType());
                reviewAndRating.setRating(reviewAndRatingDTO.getRating());
                reviewAndRating.setCandidateId(reviewAndRatingDTO.getCandidateId());
                Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(reviewAndRatingDTO.getCompanyId());
                reviewAndRating.setCompanyProfile(companyProfile.get());
                reviewAndRating.setVideoUrl(reviewVideoUrl + companyUser.get().getUser().getId() + "-" +
                        companyUser.get().getUser().getName() + "/" + unique + reviewAndRatingDTO.getVideo().getOriginalFilename());
                reviewAndRating.setRateBy(userType);
                reviewAndRating.setDate(new Date());
                reviewAndRatingRepository.save(reviewAndRating);
                Double avgRating = reviewAndRatingRepository.getAverageRatingByCompanyProfileId(companyId, "candidate");
                companyProfile.get().setAvgRating(avgRating);
                companyProfileRepository.save(companyProfile.get());
                if (!user.getUserType().equalsIgnoreCase("candidate")) {
                    return new ApiResponse(200, "Get successfull rated", avgRating);
                }
                return new ApiResponse(200, "Successfully rated by candidate", companyProfileRepository.getByCompanyId(companyId, "candidate"), avgRating);

            }

        } else if (reviewAndRatingDTO.getRating() != null && reviewAndRatingDTO.getReview() != null) {

            ReviewAndRating reviewAndRating = new ReviewAndRating();
            reviewAndRating.setRating(reviewAndRatingDTO.getRating());
            reviewAndRating.setReview(reviewAndRatingDTO.getReview());
            reviewAndRating.setCandidateId(reviewAndRatingDTO.getCandidateId());
            reviewAndRating.setRateBy(userType);
            reviewAndRating.setType("text");
            reviewAndRating.setDate(new Date());

            Optional<CompanyProfile> companyProfile = companyProfileRepository.findById(reviewAndRatingDTO.getCompanyId());
            if (companyProfile.isPresent()) {

                reviewAndRating.setCompanyProfile(companyProfile.get());
                reviewAndRatingRepository.save(reviewAndRating);

                Double avgRating = reviewAndRatingRepository.getAverageRatingByCompanyProfileId(companyId, "candidate");
                companyProfile.get().setAvgRating(avgRating);
                companyProfileRepository.save(companyProfile.get());
                if (!user.getUserType().equalsIgnoreCase("candidate")) {
                    return new ApiResponse(200, "Get successfull rated", avgRating);
                }
                return new ApiResponse(200, "Successfully rated by candidate", companyProfileRepository.getByCompanyId(companyId, "candidate"), avgRating);

            }
        }


        return new ApiResponse(500, "Something went wrong", null);

    }


    public ApiResponse saveReviewAgainstCandidate(ReviewAndRatingDTO reviewAndRatingDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userDaoRepository.findByEmail(currentPrincipalName);
        Optional<CandidateProfile> reviewGetter = candidateProfileRepository.findById(reviewAndRatingDTO.getCandidateId());
        ReviewAndRating reviewAndRatingModel = new ReviewAndRating();
        reviewAndRatingDTO.setCompanyId(user.getCompanyProfile().getId());

        ReviewAndRating reviewAndRating = reviewAndRatingRepository.checkReviewStatus(reviewAndRatingDTO.getCandidateId(), reviewAndRatingDTO.getCompanyId(), user.getUserType());

        if (reviewAndRating == null && reviewAndRatingDTO.getType().equalsIgnoreCase("text")) {
            //text review save

            reviewAndRatingModel.setDate(new Date());
            reviewAndRatingModel.setCandidateId(reviewAndRatingDTO.getCandidateId());
            reviewAndRatingModel.setCompanyProfile(user.getCompanyProfile());
            reviewAndRatingModel.setReview(reviewAndRatingDTO.getReview());
            reviewAndRatingModel.setType(reviewAndRatingDTO.getType());
            reviewAndRatingModel.setRating(reviewAndRatingDTO.getRating());
            reviewAndRatingModel.setRateBy(user.getUserType());
            reviewAndRatingRepository.save(reviewAndRatingModel);

            return
                    new ApiResponse(200, "SucesssFull",
                            reviewAndRatingRepository.getAllCompaniesWithReviews(reviewAndRatingDTO.getCandidateId()),
                            reviewAndRatingRepository.getAverageCandidateRating(reviewAndRatingDTO.getCandidateId()));
        } else if (reviewAndRating == null && reviewAndRatingDTO.getType().equalsIgnoreCase("video")) {
            //video type save
            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            if (saveVideoReview(reviewAndRatingDTO.getVideo(), reviewGetter.get().getUser().getName(),
                    reviewGetter.get().getUser().getId(), unique)) {

                reviewAndRatingModel.setVideoUrl(reviewVideoUrl + reviewGetter.get().getUser().getId() + "-" +
                        reviewGetter.get().getUser().getName() + "/" + unique + reviewAndRatingDTO.getVideo().getOriginalFilename());

                reviewAndRatingModel.setDate(new Date());
                reviewAndRatingModel.setCandidateId(reviewAndRatingDTO.getCandidateId());
                reviewAndRatingModel.setCompanyProfile(user.getCompanyProfile());
                reviewAndRatingModel.setType(reviewAndRatingDTO.getType());
                reviewAndRatingModel.setRating(reviewAndRatingDTO.getRating());
                reviewAndRatingModel.setRateBy(user.getUserType());
                reviewAndRatingRepository.save(reviewAndRatingModel);

                return
                        new ApiResponse(200, "SucesssFull",
                                reviewAndRatingRepository.getAllCompaniesWithReviews(reviewAndRatingDTO.getCandidateId()),
                                reviewAndRatingRepository.getAverageCandidateRating(reviewAndRatingDTO.getCandidateId()));
            }


        }

        return new ApiResponse(500, "Something went wrong", null);

    }

    public ResponseEntity<InputStreamResource> getImage(String filename, String userIdAndName) throws IOException {
        String filepath = Constants.SERVER_PATH + "//" + "serverFiles//" + userIdAndName + "//" + filename;
        File f = new File(filepath);
        Resource file = new UrlResource(f.toURI());
        return ResponseEntity
                .ok()
                .contentLength(file.contentLength())
                .contentType(
                        MediaType.parseMediaType("video/mp4"))
                .body(new InputStreamResource(file.getInputStream()));
    }

    public Boolean saveVideoReview(MultipartFile file, String name, Long id, String unique) {
        try {

            String UPLOADED_FOLDER_NEW = Constants.SERVER_PATH + "//" + "serverFiles//" + id + "-" + name + "//";

            File dir = new File(UPLOADED_FOLDER_NEW);
            dir.setExecutable(true);
            dir.setReadable(true);
            dir.setWritable(true);

            if (!dir.exists()) {
                dir.mkdirs();
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER_NEW + unique + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public ResponseEntity deleteReview(Long id) {
        reviewAndRatingRepository.deleteById(id);

        return new ResponseEntity<>("\" review successfully deleted\"", HttpStatus.OK);
    }

    public ResponseEntity updateReview(Long id, ReviewAndRatingDTO reviewAndRatingDTO) {

        Optional<ReviewAndRating> reviewAndRating = reviewAndRatingRepository.findById(id);


        if (reviewAndRating.isPresent()) {
            if (reviewAndRatingDTO.getType().equalsIgnoreCase("text")) {
                reviewAndRating.get().setReview(reviewAndRatingDTO.getReview());
                reviewAndRating.get().setRating(reviewAndRatingDTO.getRating());
                reviewAndRatingRepository.save(reviewAndRating.get());
                return new ResponseEntity<>("\" review successfully updated\"", HttpStatus.OK);
            } else {
                String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
                //video rating
                if (reviewAndRating.get().getRateBy().equalsIgnoreCase("candidate")) {
                    Optional<CompanyProfile> reviewGetter = companyProfileRepository.findById(reviewAndRating.get().getCompanyProfile().getId());

                    if (reviewGetter.isPresent()) {
                        if (saveVideoReview(reviewAndRatingDTO.getVideo(), reviewGetter.get().getUser().getName(),
                                reviewGetter.get().getUser().getId(), unique)) {

                            reviewAndRating.get().setVideoUrl(reviewVideoUrl + reviewGetter.get().getUser().getId() + "-" +
                                    reviewGetter.get().getUser().getName() + "/" + unique + reviewAndRatingDTO.getVideo().getOriginalFilename());
                            reviewAndRating.get().setRating(reviewAndRatingDTO.getRating());
                            reviewAndRatingRepository.save(reviewAndRating.get());
                            return new ResponseEntity<>("\" review successfully updated\"", HttpStatus.OK);
                        }
                    }
                } else {

                    Optional<CandidateProfile> reviewGetter1 = candidateProfileRepository.findById(reviewAndRating.get().getCandidateId());

                    if (reviewGetter1.isPresent()) {
                        if (saveVideoReview(reviewAndRatingDTO.getVideo(), reviewGetter1.get().getUser().getName(),
                                reviewGetter1.get().getUser().getId(), unique)) {

                            reviewAndRating.get().setVideoUrl(reviewVideoUrl + reviewGetter1.get().getUser().getId() + "-" +
                                    reviewGetter1.get().getUser().getName() + "/" + unique + reviewAndRatingDTO.getVideo().getOriginalFilename());
                            reviewAndRating.get().setRating(reviewAndRatingDTO.getRating());
                            reviewAndRatingRepository.save(reviewAndRating.get());
                            return new ResponseEntity<>("\" review successfully updated\"", HttpStatus.OK);
                        }
                    }
                }


            }

            return new ResponseEntity<>("\" review not updated\"", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("\" review not updated\"", HttpStatus.NOT_FOUND);
    }
}

