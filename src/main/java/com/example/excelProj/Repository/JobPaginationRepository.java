package com.example.excelProj.Repository;

import com.example.excelProj.Model.Job;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Rehan on 3/22/2020.
 */
@Repository
public interface JobPaginationRepository extends PagingAndSortingRepository<Job,Long>{

}
