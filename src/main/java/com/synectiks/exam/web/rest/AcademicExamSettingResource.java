package com.synectiks.exam.web.rest;

import com.synectiks.exam.service.AcademicExamSettingService;
import com.synectiks.exam.web.rest.errors.BadRequestAlertException;
import com.synectiks.exam.service.dto.AcademicExamSettingDTO;

import com.synectiks.exam.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.synectiks.exam.domain.AcademicExamSetting}.
 */
@RestController
@RequestMapping("/api")
public class AcademicExamSettingResource {

    private final Logger log = LoggerFactory.getLogger(AcademicExamSettingResource.class);

    private static final String ENTITY_NAME = "examAcademicExamSetting";

    private String applicationName;

    private final AcademicExamSettingService academicExamSettingService;

    public AcademicExamSettingResource(AcademicExamSettingService academicExamSettingService) {
        this.academicExamSettingService = academicExamSettingService;
    }

    /**
     * {@code POST  /academic-exam-settings} : Create a new academicExamSetting.
     *
     * @param academicExamSettingDTO the academicExamSettingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new academicExamSettingDTO, or with status {@code 400 (Bad Request)} if the academicExamSetting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/academic-exam-settings")
    public ResponseEntity<AcademicExamSettingDTO> createAcademicExamSetting(@RequestBody AcademicExamSettingDTO academicExamSettingDTO) throws URISyntaxException {
        log.debug("REST request to save AcademicExamSetting : {}", academicExamSettingDTO);
        if (academicExamSettingDTO.getId() != null) {
            throw new BadRequestAlertException("A new academicExamSetting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AcademicExamSettingDTO result = academicExamSettingService.save(academicExamSettingDTO);
        return ResponseEntity.created(new URI("/api/academic-exam-settings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /academic-exam-settings} : Updates an existing academicExamSetting.
     *
     * @param academicExamSettingDTO the academicExamSettingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated academicExamSettingDTO,
     * or with status {@code 400 (Bad Request)} if the academicExamSettingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the academicExamSettingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/academic-exam-settings")
    public ResponseEntity<AcademicExamSettingDTO> updateAcademicExamSetting(@RequestBody AcademicExamSettingDTO academicExamSettingDTO) throws URISyntaxException {
        log.debug("REST request to update AcademicExamSetting : {}", academicExamSettingDTO);
        if (academicExamSettingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AcademicExamSettingDTO result = academicExamSettingService.save(academicExamSettingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, academicExamSettingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /academic-exam-settings} : get all the academicExamSettings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of academicExamSettings in body.
     */
    @GetMapping("/academic-exam-settings")
    public List<AcademicExamSettingDTO> getAllAcademicExamSettings() {
        log.debug("REST request to get all AcademicExamSettings");
        return academicExamSettingService.findAll();
    }

    /**
     * {@code GET  /academic-exam-settings/:id} : get the "id" academicExamSetting.
     *
     * @param id the id of the academicExamSettingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the academicExamSettingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/academic-exam-settings/{id}")
    public ResponseEntity<AcademicExamSettingDTO> getAcademicExamSetting(@PathVariable Long id) {
        log.debug("REST request to get AcademicExamSetting : {}", id);
        Optional<AcademicExamSettingDTO> academicExamSettingDTO = academicExamSettingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(academicExamSettingDTO);
    }

    /**
     * {@code DELETE  /academic-exam-settings/:id} : delete the "id" academicExamSetting.
     *
     * @param id the id of the academicExamSettingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/academic-exam-settings/{id}")
    public ResponseEntity<Void> deleteAcademicExamSetting(@PathVariable Long id) {
        log.debug("REST request to delete AcademicExamSetting : {}", id);
        academicExamSettingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
