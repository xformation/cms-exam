package com.synectiks.exam.service;

import com.synectiks.exam.service.dto.TypeOfGradingDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.synectiks.exam.domain.TypeOfGrading}.
 */
public interface TypeOfGradingService {

    /**
     * Save a typeOfGrading.
     *
     * @param typeOfGradingDTO the entity to save.
     * @return the persisted entity.
     */
    TypeOfGradingDTO save(TypeOfGradingDTO typeOfGradingDTO);

    /**
     * Get all the typeOfGradings.
     *
     * @return the list of entities.
     */
    List<TypeOfGradingDTO> findAll();

    /**
     * Get the "id" typeOfGrading.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TypeOfGradingDTO> findOne(Long id);

    /**
     * Delete the "id" typeOfGrading.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
