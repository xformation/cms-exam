package com.synectiks.exam.service.impl;

import com.synectiks.exam.service.TypeOfGradingService;
import com.synectiks.exam.domain.TypeOfGrading;
import com.synectiks.exam.repository.TypeOfGradingRepository;
import com.synectiks.exam.service.dto.TypeOfGradingDTO;
import com.synectiks.exam.service.mapper.TypeOfGradingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link TypeOfGrading}.
 */
@Service
@Transactional
public class TypeOfGradingServiceImpl implements TypeOfGradingService {

    private final Logger log = LoggerFactory.getLogger(TypeOfGradingServiceImpl.class);

    private final TypeOfGradingRepository typeOfGradingRepository;

    private final TypeOfGradingMapper typeOfGradingMapper;

    public TypeOfGradingServiceImpl(TypeOfGradingRepository typeOfGradingRepository, TypeOfGradingMapper typeOfGradingMapper) {
        this.typeOfGradingRepository = typeOfGradingRepository;
        this.typeOfGradingMapper = typeOfGradingMapper;
    }

    /**
     * Save a typeOfGrading.
     *
     * @param typeOfGradingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public TypeOfGradingDTO save(TypeOfGradingDTO typeOfGradingDTO) {
        log.debug("Request to save TypeOfGrading : {}", typeOfGradingDTO);
        TypeOfGrading typeOfGrading = typeOfGradingMapper.toEntity(typeOfGradingDTO);
        typeOfGrading = typeOfGradingRepository.save(typeOfGrading);
        return typeOfGradingMapper.toDto(typeOfGrading);
    }

    /**
     * Get all the typeOfGradings.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TypeOfGradingDTO> findAll() {
        log.debug("Request to get all TypeOfGradings");
        return typeOfGradingRepository.findAll().stream()
            .map(typeOfGradingMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one typeOfGrading by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TypeOfGradingDTO> findOne(Long id) {
        log.debug("Request to get TypeOfGrading : {}", id);
        return typeOfGradingRepository.findById(id)
            .map(typeOfGradingMapper::toDto);
    }

    /**
     * Delete the typeOfGrading by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TypeOfGrading : {}", id);
        typeOfGradingRepository.deleteById(id);
    }
}
