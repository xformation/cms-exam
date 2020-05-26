package com.synectiks.exam.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.synectiks.exam.business.service.CommonService;
import com.synectiks.exam.business.service.ExamService;
import com.synectiks.exam.config.ApplicationProperties;
import com.synectiks.exam.domain.*;
import com.synectiks.exam.domain.vo.CmsAcademicExamSettingVo;
import com.synectiks.exam.domain.vo.ExamFilterDataCache;
import com.synectiks.exam.filter.exam.ExamFilterProcessor;
import com.synectiks.exam.repository.CompetitiveExamRepository;
import com.synectiks.exam.repository.StudentExamReportRepository;
import com.synectiks.exam.repository.AcademicExamSettingRepository;
import com.synectiks.exam.repository.TypeOfGradingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query  implements GraphQLQueryResolver {
    private final static Logger logger = LoggerFactory.getLogger(Query.class);

    private final AcademicExamSettingRepository academicExamSettingRepository;

    private final TypeOfGradingRepository typeOfGradingRepository;

    private final StudentExamReportRepository studentExamReportRepository;

    private final CompetitiveExamRepository competitiveExamRepository;

    @Autowired
    private ExamFilterProcessor examFilterProcessor;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ExamService examService;



    public Query(AcademicExamSettingRepository academicExamSettingRepository,
                 TypeOfGradingRepository typeOfGradingRepository,
                 CompetitiveExamRepository competitiveExamRepository,
                 StudentExamReportRepository studentExamReportRepository)
    {
        this.academicExamSettingRepository = academicExamSettingRepository;
        this.typeOfGradingRepository = typeOfGradingRepository;
        this.competitiveExamRepository =  competitiveExamRepository;
        this.studentExamReportRepository = studentExamReportRepository;
    }

    public AcademicExamSetting academicExamSetting (long id) {
        return academicExamSettingRepository.findById(id).get();
    }

    public List<AcademicExamSetting> academicExamSettings() {
        return Lists.newArrayList(academicExamSettingRepository.findAll());
    }

    public List<TypeOfGrading> typeOfGradings() {
        return Lists.newArrayList(typeOfGradingRepository.findAll());
    }

    public TypeOfGrading typeOfGrading(long id) {
        return typeOfGradingRepository.findById(id).get();
    }

    public StudentExamReport studentExamReport(long id) {
        return studentExamReportRepository.findById(id).get();
    }

    public List<StudentExamReport> studentExamReports() {
        return Lists.newArrayList(studentExamReportRepository.findAll());
    }

    public CompetitiveExam competitiveExam(long id) {
        return competitiveExamRepository.findById(id).get();
    }

    public List<CompetitiveExam> competitiveExams() {
        return Lists.newArrayList(competitiveExamRepository.findAll());
    }

    public List<CmsAcademicExamSettingVo> searchAcademicExamSetting(Long sectionId, Long subjectId, Long departmentId, Long batchId, Long branchId, String semester, String examName){
        return Lists.newArrayList(examFilterProcessor.searchAcademicExamSetting(sectionId, subjectId, departmentId, batchId, branchId, semester, examName));
    }

    public ExamFilterDataCache createExamFilterDataCache(Long branchId, Long departmentId,Long academicYearId) throws Exception{
        String preUrl = this.applicationProperties.getPrefSrvUrl();
        List<Branch> branchList = this.commonService.findAllBranch();
        List<Department> departmentList = this.commonService.findAllDepartment();
        List<Batch> batchList = this.commonService.findAllBatches();
        List<Section> sectionList = this.commonService.findAllSections();
        List<CmsAcademicExamSettingVo> examsList= this.examService.getAcademicList();
        List<Subject> sub = this.commonService.findAllSubject();
        ExamFilterDataCache cache = new ExamFilterDataCache();
        cache.setBranches(branchList);
        cache.setDepartments(departmentList);
        cache.setBatches(batchList);
        cache.setAcademicExamSettings(examsList);
        cache.setSubjects(sub);
        cache.setSections(sectionList);
        return cache;
    }

}
