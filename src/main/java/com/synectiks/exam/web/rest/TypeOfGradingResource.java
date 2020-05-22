package com.synectiks.exam.web.rest;

import com.synectiks.exam.service.TypeOfGradingService;
import com.synectiks.exam.web.rest.errors.BadRequestAlertException;
import com.synectiks.exam.service.dto.TypeOfGradingDTO;

import com.synectiks.exam.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.synectiks.exam.domain.TypeOfGrading}.
 */
@RestController
@RequestMapping("/api")
public class TypeOfGradingResource {

    private final Logger log = LoggerFactory.getLogger(TypeOfGradingResource.class);

    private static final String ENTITY_NAME = "examTypeOfGrading";

    private String applicationName;

    private final TypeOfGradingService typeOfGradingService;

    public TypeOfGradingResource(TypeOfGradingService typeOfGradingService) {
        this.typeOfGradingService = typeOfGradingService;
    }

    /**
     * {@code POST  /type-of-gradings} : Create a new typeOfGrading.
     *
     * @param typeOfGradingDTO the typeOfGradingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeOfGradingDTO, or with status {@code 400 (Bad Request)} if the typeOfGrading has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/type-of-gradings")
    public ResponseEntity<TypeOfGradingDTO> createTypeOfGrading(@RequestBody TypeOfGradingDTO typeOfGradingDTO) throws URISyntaxException {
        log.debug("REST request to save TypeOfGrading : {}", typeOfGradingDTO);
        if (typeOfGradingDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeOfGrading cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeOfGradingDTO result = typeOfGradingService.save(typeOfGradingDTO);
        return ResponseEntity.created(new URI("/api/type-of-gradings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /type-of-gradings} : Updates an existing typeOfGrading.
     *
     * @param typeOfGradingDTO the typeOfGradingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeOfGradingDTO,
     * or with status {@code 400 (Bad Request)} if the typeOfGradingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeOfGradingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/type-of-gradings")
    public ResponseEntity<TypeOfGradingDTO> updateTypeOfGrading(@RequestBody TypeOfGradingDTO typeOfGradingDTO) throws URISyntaxException {
        log.debug("REST request to update TypeOfGrading : {}", typeOfGradingDTO);
        if (typeOfGradingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeOfGradingDTO result = typeOfGradingService.save(typeOfGradingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, typeOfGradingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /type-of-gradings} : get all the typeOfGradings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeOfGradings in body.
     */
    @GetMapping("/type-of-gradings")
    public List<TypeOfGradingDTO> getAllTypeOfGradings() {
        log.debug("REST request to get all TypeOfGradings");
        return typeOfGradingService.findAll();
    }

    /**
     * {@code GET  /type-of-gradings/:id} : get the "id" typeOfGrading.
     *
     * @param id the id of the typeOfGradingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeOfGradingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/type-of-gradings/{id}")
    public ResponseEntity<TypeOfGradingDTO> getTypeOfGrading(@PathVariable Long id) {
        log.debug("REST request to get TypeOfGrading : {}", id);
        Optional<TypeOfGradingDTO> typeOfGradingDTO = typeOfGradingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeOfGradingDTO);
    }

    /**
     * {@code DELETE  /type-of-gradings/:id} : delete the "id" typeOfGrading.
     *
     * @param id the id of the typeOfGradingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/type-of-gradings/{id}")
    public ResponseEntity<Void> deleteTypeOfGrading(@PathVariable Long id) {
        log.debug("REST request to delete TypeOfGrading : {}", id);
        typeOfGradingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
