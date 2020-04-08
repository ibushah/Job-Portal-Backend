package com.example.excelProj.Repository;

import com.example.excelProj.Model.ReviewAndRating;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Rehan on 3/27/2020.
 */
@Repository
public interface ReviewAndRatingRepository  extends JpaRepository<ReviewAndRating,Long>{

    @Query(value = "SELECT AVG(rating) from  review_and_rating where company_id=:id",nativeQuery = true)
    public Double getAverageRatingByCompanyProfileId(@Param("id")Long id);


    public Optional<ReviewAndRating> findByCandidateIdAndCompanyProfileId(Long candidateId, Long companyId);
}
