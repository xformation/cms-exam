package com.synectiks.exam.web.rest;

import com.synectiks.exam.service.StudentExamReportService;
import com.synectiks.exam.web.rest.errors.BadRequestAlertException;
import com.synectiks.exam.service.dto.StudentExamReportDTO;

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
 * REST controller for managing {@link com.synectiks.exam.domain.StudentExamReport}.
 */
@RestController
@RequestMapping("/api")
public class StudentExamReportResource {

    private final Logger log = LoggerFactory.getLogger(StudentExamReportResource.class);

    private static final String ENTITY_NAME = "examStudentExamReport";

    private String applicationName;

    private final StudentExamReportService studentExamReportService;

    public StudentExamReportResource(StudentExamReportService studentExamReportService) {
        this.studentExamReportService = studentExamReportService;
    }

    /**
     * {@code POST  /student-exam-reports} : Create a new studentExamReport.
     *
     * @param studentExamReportDTO the studentExamReportDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new studentExamReportDTO, or with status {@code 400 (Bad Request)} if the studentExamReport has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/student-exam-reports")
    public ResponseEntity<StudentExamReportDTO> createStudentExamReport(@RequestBody StudentExamReportDTO studentExamReportDTO) throws URISyntaxException {
        log.debug("REST request to save StudentExamReport : {}", studentExamReportDTO);
        if (studentExamReportDTO.getId() != null) {
            throw new BadRequestAlertException("A new studentExamReport cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StudentExamReportDTO result = studentExamReportService.save(studentExamReportDTO);
        return ResponseEntity.created(new URI("/api/student-exam-reports/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /student-exam-reports} : Updates an existing studentExamReport.
     *
     * @param studentExamReportDTO the studentExamReportDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated studentExamReportDTO,
     * or with status {@code 400 (Bad Request)} if the studentExamReportDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the studentExamReportDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/student-exam-reports")
    public ResponseEntity<StudentExamReportDTO> updateStudentExamReport(@RequestBody StudentExamReportDTO studentExamReportDTO) throws URISyntaxException {
        log.debug("REST request to update StudentExamReport : {}", studentExamReportDTO);
        if (studentExamReportDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StudentExamReportDTO result = studentExamReportService.save(studentExamReportDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, studentExamReportDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /student-exam-reports} : get all the studentExamReports.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of studentExamReports in body.
     */
    @GetMapping("/student-exam-reports")
    public List<StudentExamReportDTO> getAllStudentExamReports() {
        log.debug("REST request to get all StudentExamReports");
        return studentExamReportService.findAll();
    }

    /**
     * {@code GET  /student-exam-reports/:id} : get the "id" studentExamReport.
     *
     * @param id the id of the studentExamReportDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the studentExamReportDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/student-exam-reports/{id}")
    public ResponseEntity<StudentExamReportDTO> getStudentExamReport(@PathVariable Long id) {
        log.debug("REST request to get StudentExamReport : {}", id);
        Optional<StudentExamReportDTO> studentExamReportDTO = studentExamReportService.findOne(id);
        return ResponseUtil.wrapOrNotFound(studentExamReportDTO);
    }

    /**
     * {@code DELETE  /student-exam-reports/:id} : delete the "id" studentExamReport.
     *
     * @param id the id of the studentExamReportDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/student-exam-reports/{id}")
    public ResponseEntity<Void> deleteStudentExamReport(@PathVariable Long id) {
        log.debug("REST request to delete StudentExamReport : {}", id);
        studentExamReportService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
