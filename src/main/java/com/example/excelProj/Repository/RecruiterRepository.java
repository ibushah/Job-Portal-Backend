package com.example.excelProj.Repository;

import com.example.excelProj.Model.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rehan on 5/28/2020.
 */
@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterProfile,Long>{
    public RecruiterProfile findByUserId(Long userId);
}

