package com.synectiks.exam.service.impl;

import com.synectiks.exam.service.AcademicExamSettingService;
import com.synectiks.exam.domain.AcademicExamSetting;
import com.synectiks.exam.repository.AcademicExamSettingRepository;
import com.synectiks.exam.service.dto.AcademicExamSettingDTO;
import com.synectiks.exam.service.mapper.AcademicExamSettingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link AcademicExamSetting}.
 */
@Service
@Transactional
public class AcademicExamSettingServiceImpl implements AcademicExamSettingService {

    private final Logger log = LoggerFactory.getLogger(AcademicExamSettingServiceImpl.class);

    private final AcademicExamSettingRepository academicExamSettingRepository;

    private final AcademicExamSettingMapper academicExamSettingMapper;

    public AcademicExamSettingServiceImpl(AcademicExamSettingRepository academicExamSettingRepository, AcademicExamSettingMapper academicExamSettingMapper) {
        this.academicExamSettingRepository = academicExamSettingRepository;
        this.academicExamSettingMapper = academicExamSettingMapper;
    }

    /**
     * Save a academicExamSetting.
     *
     * @param academicExamSettingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public AcademicExamSettingDTO save(AcademicExamSettingDTO academicExamSettingDTO) {
        log.debug("Request to save AcademicExamSetting : {}", academicExamSettingDTO);
        AcademicExamSetting academicExamSetting = academicExamSettingMapper.toEntity(academicExamSettingDTO);
        academicExamSetting = academicExamSettingRepository.save(academicExamSetting);
        return academicExamSettingMapper.toDto(academicExamSetting);
    }

    /**
     * Get all the academicExamSettings.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<AcademicExamSettingDTO> findAll() {
        log.debug("Request to get all AcademicExamSettings");
        return academicExamSettingRepository.findAll().stream()
            .map(academicExamSettingMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one academicExamSetting by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AcademicExamSettingDTO> findOne(Long id) {
        log.debug("Request to get AcademicExamSetting : {}", id);
        return academicExamSettingRepository.findById(id)
            .map(academicExamSettingMapper::toDto);
    }

    /**
     * Delete the academicExamSetting by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AcademicExamSetting : {}", id);
        academicExamSettingRepository.deleteById(id);
    }
}
