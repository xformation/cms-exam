package com.synectiks.exam.repository;

import com.synectiks.exam.domain.StudentExamReport;

import com.synectiks.exam.utils.JPASearchRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the StudentExamReport entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StudentExamReportRepository extends JPASearchRepository<StudentExamReport, Long> {

}
