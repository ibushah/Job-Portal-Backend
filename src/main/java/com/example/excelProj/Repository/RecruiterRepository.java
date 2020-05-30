package com.example.excelProj.Repository;

import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Model.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rehan on 5/28/2020.
 */
@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterProfile,Long>{
    public RecruiterProfile findByUserId(Long userId);

    @Query(value = "SELECT new com.example.excelProj.Dto.CompanyReviewRatingDTO(u.id,candp.id,u.name,u.email,\n" +
            "r.Rating,r.review,candp.cv," +
            "candp.dp,candp.field," +
            "candp.imageContentType,\n" +
            "candp.resumeContentType,r.date)\n"+
            "FROM ReviewAndRating r \n" +
            "JOIN CandidateProfile candp \n" +
            "ON r.candidateId=candp.id \n" +
            "JOIN User u on candp.user.id=u.id where r.recruiterProfile.id=:id AND r.rateBy=:userType")
    List<CompanyReviewRatingDTO> getAllReviewsAndRatingOfRecruiterProfile(@Param("id") Long id, @Param("userType") String userType);

}

