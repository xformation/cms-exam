package com.synectiks.exam.repository;

import com.synectiks.exam.domain.CompetitiveExam;

import com.synectiks.exam.utils.JPASearchRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CompetitiveExam entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompetitiveExamRepository extends JPASearchRepository<CompetitiveExam, Long> {

}
