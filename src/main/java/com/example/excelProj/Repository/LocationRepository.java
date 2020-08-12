package com.example.excelProj.Repository;

import com.example.excelProj.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LocationRepository extends JpaRepository<Location, Long> {


    @Transactional
    @Modifying
    @Query(value = "update location set longitude=:longitude, latitude=:latitude where user_id=:id", nativeQuery = true)
    void setLongitudeAndLatitude(@Param("id") Long id,@Param("longitude") Double Longitude,@Param("latitude") Double latitude);

    @Query(value ="select * from location where user_id=:userId" ,nativeQuery = true)
    Location findLocationByUserId(@Param("userId") Long userId);
}
