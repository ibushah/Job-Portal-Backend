package com.example.excelProj.Repository;

import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.ReviewAndRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {

    public CompanyProfile findByUserId(Long id);

    @Query(value = "SELECT new com.example.excelProj.Dto.CompanyReviewRatingDTO(r.id,u.name,u.email,\n" +
            "r.Rating,r.review,candp.cv," +
            "candp.dp,candp.field," +
            "candp.imageContentType,\n" +
            "candp.resumeContentType,r.date)\n"+
            "FROM ReviewAndRating r \n" +
            "JOIN CandidateProfile candp \n" +
            "ON r.ratedBy=candp.user.email\n" +
            "JOIN User u on candp.user.id=u.id where r.companyProfile.id=:id")
List<CompanyReviewRatingDTO> getByCompanyId(@Param("id") Long id);

    @Query(value = "select * from company_profile where user_id=:id",nativeQuery = true)
    public CompanyProfile getCompanyProfileAgainstUserId(@Param("id") Long id);




}
