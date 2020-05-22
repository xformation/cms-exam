package com.synectiks.exam.repository;

import com.synectiks.exam.domain.AcademicExamSetting;

import com.synectiks.exam.utils.JPASearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AcademicExamSetting entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AcademicExamSettingRepository extends JPASearchRepository<AcademicExamSetting, Long> {

}
