package com.example.excelProj.Repository;

import com.example.excelProj.Model.TenderAssortments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenderAssortmentRepository extends JpaRepository<TenderAssortments,Long> {
}
