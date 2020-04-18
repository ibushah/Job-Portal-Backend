package com.example.excelProj.Specifications;

import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.Job;
import jdk.nashorn.internal.scripts.JO;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Rehan on 4/18/2020.
 */
public interface JobSearchSPECIFICATIONS {
    static Specification<Job> hasType(String type) {
        return (jobRoot, cq, cb) -> cb.equal(jobRoot.get("type"), type);
    }

    static Specification<Job> hasCity(String city) {
        return (jobRoot, cq, cb) -> cb.equal(jobRoot.get("city"), city);
    }

    static Specification<Job> hasCompany(Long employee_id) {
        return (jobRoot, cq, cb) -> cb.equal(jobRoot.get("companyProfile"), employee_id);
    }


//    static Specification<Job> hasCompany(String companyName) {
//
//
//    }



//    static Specification<Job> titleContains(String title) {
//        return (jobRoot, cq, cb) -> cb.like(jobRoot.get("title"), "%" + title + "%");
//    }
}
