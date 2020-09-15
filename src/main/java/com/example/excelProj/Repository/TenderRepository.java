package com.example.excelProj.Repository;

import com.example.excelProj.Model.Tender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenderRepository extends JpaRepository<Tender,Long> {
}
