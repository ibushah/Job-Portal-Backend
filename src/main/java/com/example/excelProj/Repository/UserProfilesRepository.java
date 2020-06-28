package com.example.excelProj.Repository;


import com.example.excelProj.Model.UserProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Rehan on 6/27/2020.
 */
@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfiles,Long>{

    @Query(value = "Select * from user_profiles where user_id=:id",nativeQuery = true)
    public UserProfiles findByUserId(@Param("id") Long id);
}
