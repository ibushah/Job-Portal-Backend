package com.example.excelProj.Repository;

import com.example.excelProj.Dto.AllCompaniesWithReviewDTO;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Model.ReviewAndRating;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rehan on 3/27/2020.
 */
@Repository
public interface ReviewAndRatingRepository  extends JpaRepository<ReviewAndRating,Long>{

    @Query(value = "SELECT AVG(rating) from  review_and_rating where company_id=:id",nativeQuery = true)
     Double getAverageRatingByCompanyProfileId(@Param("id")Long id);


     Optional<ReviewAndRating> findByCandidateIdAndCompanyProfileId(Long candidateId,Long comanyId);


//    ALL THE COMANIES WITH REVIEWS AGFAINST THIS CANDIDATE ID
//    rate by employee means candidate ko yeh rating di gai hain
                @Query(value = "SELECT new com.example.excelProj.Dto.AllCompaniesWithReviewDTO" +
                        "(comp.id,u.name,u.email,comp.corporateAddress," +
                        "comp.billingAddress,comp.contactName,comp.contactTitle,comp.logo" +
                        ",comp.logoContentType,r.review,r.Rating,r.date)\n"+
                        "FROM ReviewAndRating r \n" +
                        "JOIN CompanyProfile comp \n" +
                        "ON r.companyProfile.id=comp.id \n" +
                        "JOIN User u on comp.user.id=u.id where r.candidateId=:id AND r.rateBy=:userType")
                List<AllCompaniesWithReviewDTO> getAllCompaniesWithReviews(@Param("id") Long id,@Param("userType") String userType);

//    @Query(value = "select * from review_and_rating where rated_by;=1?",nativeQuery = true)
//    public ReviewAndRating findByRatedBy(String ratedBy);


    @Query(value = "select * from review_and_rating where candidate_id=:candId AND company_id=:companyId AND rate_by=:rateBy",nativeQuery = true)
      ReviewAndRating checkReviewStatus(@Param("candId") Long canId,@Param("companyId") Long companyId,@Param("rateBy") String rateBy);


    @Query(value = "SELECT AVG(rating) from  review_and_rating where candidate_id=:id AND rate_by=:rateBy",nativeQuery = true)
    Double getAverageCandidateRating(@Param("id")Long id,@Param("rateBy") String rateBy);
}
