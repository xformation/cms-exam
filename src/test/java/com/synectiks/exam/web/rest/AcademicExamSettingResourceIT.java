package com.synectiks.exam.web.rest;

import com.synectiks.exam.ExamApp;
import com.synectiks.exam.domain.AcademicExamSetting;
import com.synectiks.exam.repository.AcademicExamSettingRepository;
import com.synectiks.exam.service.AcademicExamSettingService;
import com.synectiks.exam.service.dto.AcademicExamSettingDTO;
import com.synectiks.exam.service.mapper.AcademicExamSettingMapper;
import com.synectiks.exam.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.synectiks.exam.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AcademicExamSettingResource} REST controller.
 */
@SpringBootTest(classes = ExamApp.class)
public class AcademicExamSettingResourceIT {

    private static final String DEFAULT_EXAM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EXAM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SEMESTER = "AAAAAAAAAA";
    private static final String UPDATED_SEMESTER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_EXAM_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXAM_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_START_TIME = "AAAAAAAAAA";
    private static final String UPDATED_START_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_END_TIME = "AAAAAAAAAA";
    private static final String UPDATED_END_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_GRADE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_GRADE_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_TOTAL = 1;
    private static final Integer UPDATED_TOTAL = 2;

    private static final Integer DEFAULT_PASSING = 1;
    private static final Integer UPDATED_PASSING = 2;

    private static final String DEFAULT_ACTIONS = "AAAAAAAAAA";
    private static final String UPDATED_ACTIONS = "BBBBBBBBBB";

    private static final Long DEFAULT_GROUPVALUE = 1L;
    private static final Long UPDATED_GROUPVALUE = 2L;

    private static final Long DEFAULT_COUNTVALUE = 1L;
    private static final Long UPDATED_COUNTVALUE = 2L;

    private static final Long DEFAULT_BRANCH_ID = 1L;
    private static final Long UPDATED_BRANCH_ID = 2L;

    private static final Long DEFAULT_SUBJECT_ID = 1L;
    private static final Long UPDATED_SUBJECT_ID = 2L;

    private static final Long DEFAULT_DEPARTMENT_ID = 1L;
    private static final Long UPDATED_DEPARTMENT_ID = 2L;

    private static final Long DEFAULT_ACADEMICYEAR_ID = 1L;
    private static final Long UPDATED_ACADEMICYEAR_ID = 2L;

    private static final Long DEFAULT_SECTION_ID = 1L;
    private static final Long UPDATED_SECTION_ID = 2L;

    private static final Long DEFAULT_BATCH_ID = 1L;
    private static final Long UPDATED_BATCH_ID = 2L;

    @Autowired
    private AcademicExamSettingRepository academicExamSettingRepository;

    @Autowired
    private AcademicExamSettingMapper academicExamSettingMapper;

    @Autowired
    private AcademicExamSettingService academicExamSettingService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restAcademicExamSettingMockMvc;

    private AcademicExamSetting academicExamSetting;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AcademicExamSettingResource academicExamSettingResource = new AcademicExamSettingResource(academicExamSettingService);
        this.restAcademicExamSettingMockMvc = MockMvcBuilders.standaloneSetup(academicExamSettingResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AcademicExamSetting createEntity(EntityManager em) {
        AcademicExamSetting academicExamSetting = new AcademicExamSetting()
            .examName(DEFAULT_EXAM_NAME)
            .semester(DEFAULT_SEMESTER)
            .examDate(DEFAULT_EXAM_DATE)
            .startTime(DEFAULT_START_TIME)
            .endTime(DEFAULT_END_TIME)
            .gradeType(DEFAULT_GRADE_TYPE)
            .total(DEFAULT_TOTAL)
            .passing(DEFAULT_PASSING)
            .actions(DEFAULT_ACTIONS)
            .groupvalue(DEFAULT_GROUPVALUE)
            .countvalue(DEFAULT_COUNTVALUE)
            .branchId(DEFAULT_BRANCH_ID)
            .subjectId(DEFAULT_SUBJECT_ID)
            .departmentId(DEFAULT_DEPARTMENT_ID)
            .academicyearId(DEFAULT_ACADEMICYEAR_ID)
            .sectionId(DEFAULT_SECTION_ID)
            .batchId(DEFAULT_BATCH_ID);
        return academicExamSetting;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AcademicExamSetting createUpdatedEntity(EntityManager em) {
        AcademicExamSetting academicExamSetting = new AcademicExamSetting()
            .examName(UPDATED_EXAM_NAME)
            .semester(UPDATED_SEMESTER)
            .examDate(UPDATED_EXAM_DATE)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .gradeType(UPDATED_GRADE_TYPE)
            .total(UPDATED_TOTAL)
            .passing(UPDATED_PASSING)
            .actions(UPDATED_ACTIONS)
            .groupvalue(UPDATED_GROUPVALUE)
            .countvalue(UPDATED_COUNTVALUE)
            .branchId(UPDATED_BRANCH_ID)
            .subjectId(UPDATED_SUBJECT_ID)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .academicyearId(UPDATED_ACADEMICYEAR_ID)
            .sectionId(UPDATED_SECTION_ID)
            .batchId(UPDATED_BATCH_ID);
        return academicExamSetting;
    }

    @BeforeEach
    public void initTest() {
        academicExamSetting = createEntity(em);
    }

    @Test
    @Transactional
    public void createAcademicExamSetting() throws Exception {
        int databaseSizeBeforeCreate = academicExamSettingRepository.findAll().size();

        // Create the AcademicExamSetting
        AcademicExamSettingDTO academicExamSettingDTO = academicExamSettingMapper.toDto(academicExamSetting);
        restAcademicExamSettingMockMvc.perform(post("/api/academic-exam-settings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(academicExamSettingDTO)))
            .andExpect(status().isCreated());

        // Validate the AcademicExamSetting in the database
        List<AcademicExamSetting> academicExamSettingList = academicExamSettingRepository.findAll();
        assertThat(academicExamSettingList).hasSize(databaseSizeBeforeCreate + 1);
        AcademicExamSetting testAcademicExamSetting = academicExamSettingList.get(academicExamSettingList.size() - 1);
        assertThat(testAcademicExamSetting.getExamName()).isEqualTo(DEFAULT_EXAM_NAME);
        assertThat(testAcademicExamSetting.getSemester()).isEqualTo(DEFAULT_SEMESTER);
        assertThat(testAcademicExamSetting.getExamDate()).isEqualTo(DEFAULT_EXAM_DATE);
        assertThat(testAcademicExamSetting.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testAcademicExamSetting.getEndTime()).isEqualTo(DEFAULT_END_TIME);
        assertThat(testAcademicExamSetting.getGradeType()).isEqualTo(DEFAULT_GRADE_TYPE);
        assertThat(testAcademicExamSetting.getTotal()).isEqualTo(DEFAULT_TOTAL);
        assertThat(testAcademicExamSetting.getPassing()).isEqualTo(DEFAULT_PASSING);
        assertThat(testAcademicExamSetting.getActions()).isEqualTo(DEFAULT_ACTIONS);
        assertThat(testAcademicExamSetting.getGroupvalue()).isEqualTo(DEFAULT_GROUPVALUE);
        assertThat(testAcademicExamSetting.getCountvalue()).isEqualTo(DEFAULT_COUNTVALUE);
        assertThat(testAcademicExamSetting.getBranchId()).isEqualTo(DEFAULT_BRANCH_ID);
        assertThat(testAcademicExamSetting.getSubjectId()).isEqualTo(DEFAULT_SUBJECT_ID);
        assertThat(testAcademicExamSetting.getDepartmentId()).isEqualTo(DEFAULT_DEPARTMENT_ID);
        assertThat(testAcademicExamSetting.getAcademicyearId()).isEqualTo(DEFAULT_ACADEMICYEAR_ID);
        assertThat(testAcademicExamSetting.getSectionId()).isEqualTo(DEFAULT_SECTION_ID);
        assertThat(testAcademicExamSetting.getBatchId()).isEqualTo(DEFAULT_BATCH_ID);
    }

    @Test
    @Transactional
    public void createAcademicExamSettingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = academicExamSettingRepository.findAll().size();

        // Create the AcademicExamSetting with an existing ID
        academicExamSetting.setId(1L);
        AcademicExamSettingDTO academicExamSettingDTO = academicExamSettingMapper.toDto(academicExamSetting);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAcademicExamSettingMockMvc.perform(post("/api/academic-exam-settings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(academicExamSettingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AcademicExamSetting in the database
        List<AcademicExamSetting> academicExamSettingList = academicExamSettingRepository.findAll();
        assertThat(academicExamSettingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAcademicExamSettings() throws Exception {
        // Initialize the database
        academicExamSettingRepository.saveAndFlush(academicExamSetting);

        // Get all the academicExamSettingList
        restAcademicExamSettingMockMvc.perform(get("/api/academic-exam-settings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(academicExamSetting.getId().intValue())))
            .andExpect(jsonPath("$.[*].examName").value(hasItem(DEFAULT_EXAM_NAME)))
            .andExpect(jsonPath("$.[*].semester").value(hasItem(DEFAULT_SEMESTER)))
            .andExpect(jsonPath("$.[*].examDate").value(hasItem(DEFAULT_EXAM_DATE.toString())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME)))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME)))
            .andExpect(jsonPath("$.[*].gradeType").value(hasItem(DEFAULT_GRADE_TYPE)))
            .andExpect(jsonPath("$.[*].total").value(hasItem(DEFAULT_TOTAL)))
            .andExpect(jsonPath("$.[*].passing").value(hasItem(DEFAULT_PASSING)))
            .andExpect(jsonPath("$.[*].actions").value(hasItem(DEFAULT_ACTIONS)))
            .andExpect(jsonPath("$.[*].groupvalue").value(hasItem(DEFAULT_GROUPVALUE.intValue())))
            .andExpect(jsonPath("$.[*].countvalue").value(hasItem(DEFAULT_COUNTVALUE.intValue())))
            .andExpect(jsonPath("$.[*].branchId").value(hasItem(DEFAULT_BRANCH_ID.intValue())))
            .andExpect(jsonPath("$.[*].subjectId").value(hasItem(DEFAULT_SUBJECT_ID.intValue())))
            .andExpect(jsonPath("$.[*].departmentId").value(hasItem(DEFAULT_DEPARTMENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].academicyearId").value(hasItem(DEFAULT_ACADEMICYEAR_ID.intValue())))
            .andExpect(jsonPath("$.[*].sectionId").value(hasItem(DEFAULT_SECTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].batchId").value(hasItem(DEFAULT_BATCH_ID.intValue())));
    }

    @Test
    @Transactional
    public void getAcademicExamSetting() throws Exception {
        // Initialize the database
        academicExamSettingRepository.saveAndFlush(academicExamSetting);

        // Get the academicExamSetting
        restAcademicExamSettingMockMvc.perform(get("/api/academic-exam-settings/{id}", academicExamSetting.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(academicExamSetting.getId().intValue()))
            .andExpect(jsonPath("$.examName").value(DEFAULT_EXAM_NAME))
            .andExpect(jsonPath("$.semester").value(DEFAULT_SEMESTER))
            .andExpect(jsonPath("$.examDate").value(DEFAULT_EXAM_DATE.toString()))
            .andExpect(jsonPath("$.startTime").value(DEFAULT_START_TIME))
            .andExpect(jsonPath("$.endTime").value(DEFAULT_END_TIME))
            .andExpect(jsonPath("$.gradeType").value(DEFAULT_GRADE_TYPE))
            .andExpect(jsonPath("$.total").value(DEFAULT_TOTAL))
            .andExpect(jsonPath("$.passing").value(DEFAULT_PASSING))
            .andExpect(jsonPath("$.actions").value(DEFAULT_ACTIONS))
            .andExpect(jsonPath("$.groupvalue").value(DEFAULT_GROUPVALUE.intValue()))
            .andExpect(jsonPath("$.countvalue").value(DEFAULT_COUNTVALUE.intValue()))
            .andExpect(jsonPath("$.branchId").value(DEFAULT_BRANCH_ID.intValue()))
            .andExpect(jsonPath("$.subjectId").value(DEFAULT_SUBJECT_ID.intValue()))
            .andExpect(jsonPath("$.departmentId").value(DEFAULT_DEPARTMENT_ID.intValue()))
            .andExpect(jsonPath("$.academicyearId").value(DEFAULT_ACADEMICYEAR_ID.intValue()))
            .andExpect(jsonPath("$.sectionId").value(DEFAULT_SECTION_ID.intValue()))
            .andExpect(jsonPath("$.batchId").value(DEFAULT_BATCH_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingAcademicExamSetting() throws Exception {
        // Get the academicExamSetting
        restAcademicExamSettingMockMvc.perform(get("/api/academic-exam-settings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAcademicExamSetting() throws Exception {
        // Initialize the database
        academicExamSettingRepository.saveAndFlush(academicExamSetting);

        int databaseSizeBeforeUpdate = academicExamSettingRepository.findAll().size();

        // Update the academicExamSetting
        AcademicExamSetting updatedAcademicExamSetting = academicExamSettingRepository.findById(academicExamSetting.getId()).get();
        // Disconnect from session so that the updates on updatedAcademicExamSetting are not directly saved in db
        em.detach(updatedAcademicExamSetting);
        updatedAcademicExamSetting
            .examName(UPDATED_EXAM_NAME)
            .semester(UPDATED_SEMESTER)
            .examDate(UPDATED_EXAM_DATE)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .gradeType(UPDATED_GRADE_TYPE)
            .total(UPDATED_TOTAL)
            .passing(UPDATED_PASSING)
            .actions(UPDATED_ACTIONS)
            .groupvalue(UPDATED_GROUPVALUE)
            .countvalue(UPDATED_COUNTVALUE)
            .branchId(UPDATED_BRANCH_ID)
            .subjectId(UPDATED_SUBJECT_ID)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .academicyearId(UPDATED_ACADEMICYEAR_ID)
            .sectionId(UPDATED_SECTION_ID)
            .batchId(UPDATED_BATCH_ID);
        AcademicExamSettingDTO academicExamSettingDTO = academicExamSettingMapper.toDto(updatedAcademicExamSetting);

        restAcademicExamSettingMockMvc.perform(put("/api/academic-exam-settings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(academicExamSettingDTO)))
            .andExpect(status().isOk());

        // Validate the AcademicExamSetting in the database
        List<AcademicExamSetting> academicExamSettingList = academicExamSettingRepository.findAll();
        assertThat(academicExamSettingList).hasSize(databaseSizeBeforeUpdate);
        AcademicExamSetting testAcademicExamSetting = academicExamSettingList.get(academicExamSettingList.size() - 1);
        assertThat(testAcademicExamSetting.getExamName()).isEqualTo(UPDATED_EXAM_NAME);
        assertThat(testAcademicExamSetting.getSemester()).isEqualTo(UPDATED_SEMESTER);
        assertThat(testAcademicExamSetting.getExamDate()).isEqualTo(UPDATED_EXAM_DATE);
        assertThat(testAcademicExamSetting.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testAcademicExamSetting.getEndTime()).isEqualTo(UPDATED_END_TIME);
        assertThat(testAcademicExamSetting.getGradeType()).isEqualTo(UPDATED_GRADE_TYPE);
        assertThat(testAcademicExamSetting.getTotal()).isEqualTo(UPDATED_TOTAL);
        assertThat(testAcademicExamSetting.getPassing()).isEqualTo(UPDATED_PASSING);
        assertThat(testAcademicExamSetting.getActions()).isEqualTo(UPDATED_ACTIONS);
        assertThat(testAcademicExamSetting.getGroupvalue()).isEqualTo(UPDATED_GROUPVALUE);
        assertThat(testAcademicExamSetting.getCountvalue()).isEqualTo(UPDATED_COUNTVALUE);
        assertThat(testAcademicExamSetting.getBranchId()).isEqualTo(UPDATED_BRANCH_ID);
        assertThat(testAcademicExamSetting.getSubjectId()).isEqualTo(UPDATED_SUBJECT_ID);
        assertThat(testAcademicExamSetting.getDepartmentId()).isEqualTo(UPDATED_DEPARTMENT_ID);
        assertThat(testAcademicExamSetting.getAcademicyearId()).isEqualTo(UPDATED_ACADEMICYEAR_ID);
        assertThat(testAcademicExamSetting.getSectionId()).isEqualTo(UPDATED_SECTION_ID);
        assertThat(testAcademicExamSetting.getBatchId()).isEqualTo(UPDATED_BATCH_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingAcademicExamSetting() throws Exception {
        int databaseSizeBeforeUpdate = academicExamSettingRepository.findAll().size();

        // Create the AcademicExamSetting
        AcademicExamSettingDTO academicExamSettingDTO = academicExamSettingMapper.toDto(academicExamSetting);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAcademicExamSettingMockMvc.perform(put("/api/academic-exam-settings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(academicExamSettingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AcademicExamSetting in the database
        List<AcademicExamSetting> academicExamSettingList = academicExamSettingRepository.findAll();
        assertThat(academicExamSettingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAcademicExamSetting() throws Exception {
        // Initialize the database
        academicExamSettingRepository.saveAndFlush(academicExamSetting);

        int databaseSizeBeforeDelete = academicExamSettingRepository.findAll().size();

        // Delete the academicExamSetting
        restAcademicExamSettingMockMvc.perform(delete("/api/academic-exam-settings/{id}", academicExamSetting.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AcademicExamSetting> academicExamSettingList = academicExamSettingRepository.findAll();
        assertThat(academicExamSettingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
