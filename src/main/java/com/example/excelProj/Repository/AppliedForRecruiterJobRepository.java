package com.example.excelProj.Repository;

import com.example.excelProj.Dto.AllCandidatesReferedOrNotList;
import com.example.excelProj.Dto.CompanyReviewRatingDTO;
import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Dto.TestDTO;
import com.example.excelProj.Model.AppliedForRecruiterJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Rehan on 5/28/2020.
 */

@Repository
public interface AppliedForRecruiterJobRepository extends JpaRepository<AppliedForRecruiterJob,Long>{

    @Query(value = "SELECT new com.example.excelProj.Dto.AllCandidatesReferedOrNotList" +
            "(u.id,u.name,candp.id,\n" +
            "candp.dp,candp.presentationLetter,candp.imageContentType," +
            "ref.appliedDate,ref.isApplied," +
            "ref.seenOrNot,ref.referedDate)"+
            "FROM CandidateProfile candp  \n" +
            " inner join  AppliedForRecruiterJob ref\n" +
            "ON candp.id=ref.candidateProfile.id \n" +
            "left JOIN User u on candp.user.id=u.id where ref.recruiterJobs.id=:id")
    List<AllCandidatesReferedOrNotList> getAllCandidates(@Param("id") Long id);


    @Query(value = "select \n" +
            "u.id as user_id,u.name,\n" +
            "candp.id as candidate_id,candp.dp,\n" +
            "candp.presentation_letter,\n" +
            "candp.image_content_type,\n" +
            "ref.applied_date,ref.is_applied,\n" +
            "ref.is_seen,ref.refered_date\n" +
            "from candidate_profile candp \n" +
            "left join (select * from applied_or_refered_recruiter_jobs  ref where recruiter_jobs_id =:id) ref on candp.id = ref.candidate_profile_id  \n" +
            "inner join user u on  u.id = candp.user_id GROUP BY u.id;",nativeQuery = true)
    List<Object[]> getAllByCandidateProfile(@Param("id") Long id);


    Optional<AppliedForRecruiterJob> findByCandidateProfileIdAndCompanyProfileIdAndRecruiterJobsIdAndIsApplied(Long candId,Long compId,Long jobId,Boolean applied);


    @Query(value = "select * from applied_or_refered_recruiter_jobs where (candidate_profile_id=:candId AND company_profile_id=:companyId AND recruiter_jobs_id=:jobId)",nativeQuery = true)
    AppliedForRecruiterJob applyOnJob(@Param("candId") Long candId,@Param("companyId") Long companyId,
                                                @Param("jobId") Long jobId);



    @Modifying
    @Transactional
    @Query(value = "DELETE from applied_or_refered_recruiter_jobs where recruiter_jobs_id=:id",nativeQuery = true)
    void deleteAssociatedRecords(@Param("id") Long id);


    @Query("Select new com.example.excelProj.Dto.NotificationDTO(a.recruiterJobs.title,a.companyProfile.user.name,a.companyProfile.logo," +
            "a.seenOrNot,a.referedDate,a.recruiterJobs.id) " +
            "from  AppliedForRecruiterJob a " +
            "where a.candidateProfile.id=:id ORDER BY a.appliedDate DESC")
    Page<NotificationDTO> getNotifications(@Param("id") Long id, Pageable page);



    @Query("select count(*) from   AppliedForRecruiterJob a where a.candidateProfile.id=:id AND a.seenOrNot=false")
    Long getNotificationsCount(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query("update AppliedForRecruiterJob a " +
            "set " +
            "a.seenOrNot = true where a.candidateProfile.id=:id")
    void setAllNoticationsAsRead(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update AppliedForRecruiterJob a set a.seenOrNot=true where a.candidateProfile.id=:id AND a.recruiterJobs.id=:jobId")
    void setSelectedNotificationAsRead(@Param("id") Long id,@Param("jobId") Long jobId);



    @Query(value = "select recruiter_jobs.id from recruiter_jobs   left join\n" +
            "(select * from applied_or_refered_recruiter_jobs where candidate_profile_id =:candId and company_profile_id=:companyId)\n" +
            " ref on recruiter_jobs.id = ref.recruiter_jobs_id\n" +
            "WHERE ref.recruiter_jobs_id is NULL",
            nativeQuery = true)
    public List<Long> getDetails(@Param("candId") Long candId, @Param("companyId") Long companyId,Pageable pageable);




}
