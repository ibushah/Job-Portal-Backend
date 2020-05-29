package com.example.excelProj.Repository;

import com.example.excelProj.Dto.NotificationDTO;
import com.example.excelProj.Model.AppliedForRecruiterJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Rehan on 5/28/2020.
 */

@Repository
public interface AppliedForRecruiterJobRepository extends JpaRepository<AppliedForRecruiterJob,Long>{



}
