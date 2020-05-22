package com.synectiks.exam.web.rest;

import com.synectiks.exam.service.CompetitiveExamService;
import com.synectiks.exam.web.rest.errors.BadRequestAlertException;
import com.synectiks.exam.service.dto.CompetitiveExamDTO;

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
 * REST controller for managing {@link com.synectiks.exam.domain.CompetitiveExam}.
 */
@RestController
@RequestMapping("/api")
public class CompetitiveExamResource {

    private final Logger log = LoggerFactory.getLogger(CompetitiveExamResource.class);

    private static final String ENTITY_NAME = "examCompetitiveExam";


    private String applicationName;

    private final CompetitiveExamService competitiveExamService;

    public CompetitiveExamResource(CompetitiveExamService competitiveExamService) {
        this.competitiveExamService = competitiveExamService;
    }

    /**
     * {@code POST  /competitive-exams} : Create a new competitiveExam.
     *
     * @param competitiveExamDTO the competitiveExamDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new competitiveExamDTO, or with status {@code 400 (Bad Request)} if the competitiveExam has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/competitive-exams")
    public ResponseEntity<CompetitiveExamDTO> createCompetitiveExam(@RequestBody CompetitiveExamDTO competitiveExamDTO) throws URISyntaxException {
        log.debug("REST request to save CompetitiveExam : {}", competitiveExamDTO);
        if (competitiveExamDTO.getId() != null) {
            throw new BadRequestAlertException("A new competitiveExam cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompetitiveExamDTO result = competitiveExamService.save(competitiveExamDTO);
        return ResponseEntity.created(new URI("/api/competitive-exams/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /competitive-exams} : Updates an existing competitiveExam.
     *
     * @param competitiveExamDTO the competitiveExamDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated competitiveExamDTO,
     * or with status {@code 400 (Bad Request)} if the competitiveExamDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the competitiveExamDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/competitive-exams")
    public ResponseEntity<CompetitiveExamDTO> updateCompetitiveExam(@RequestBody CompetitiveExamDTO competitiveExamDTO) throws URISyntaxException {
        log.debug("REST request to update CompetitiveExam : {}", competitiveExamDTO);
        if (competitiveExamDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompetitiveExamDTO result = competitiveExamService.save(competitiveExamDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, competitiveExamDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /competitive-exams} : get all the competitiveExams.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of competitiveExams in body.
     */
    @GetMapping("/competitive-exams")
    public List<CompetitiveExamDTO> getAllCompetitiveExams() {
        log.debug("REST request to get all CompetitiveExams");
        return competitiveExamService.findAll();
    }

    /**
     * {@code GET  /competitive-exams/:id} : get the "id" competitiveExam.
     *
     * @param id the id of the competitiveExamDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the competitiveExamDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/competitive-exams/{id}")
    public ResponseEntity<CompetitiveExamDTO> getCompetitiveExam(@PathVariable Long id) {
        log.debug("REST request to get CompetitiveExam : {}", id);
        Optional<CompetitiveExamDTO> competitiveExamDTO = competitiveExamService.findOne(id);
        return ResponseUtil.wrapOrNotFound(competitiveExamDTO);
    }

    /**
     * {@code DELETE  /competitive-exams/:id} : delete the "id" competitiveExam.
     *
     * @param id the id of the competitiveExamDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/competitive-exams/{id}")
    public ResponseEntity<Void> deleteCompetitiveExam(@PathVariable Long id) {
        log.debug("REST request to delete CompetitiveExam : {}", id);
        competitiveExamService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
