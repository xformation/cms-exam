package com.synectiks.exam.repository;

import com.synectiks.exam.domain.TypeOfGrading;

import com.synectiks.exam.utils.JPASearchRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TypeOfGrading entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeOfGradingRepository extends JPASearchRepository<TypeOfGrading, Long> {

}
