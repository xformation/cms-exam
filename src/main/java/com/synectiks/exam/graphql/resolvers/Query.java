package com.synectiks.exam.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.synectiks.exam.domain.AcademicExamSetting;
import com.synectiks.exam.domain.TypeOfGrading;
import com.synectiks.exam.domain.StudentExamReport;
import com.synectiks.exam.domain.CompetitiveExam;
import com.synectiks.exam.repository.CompetitiveExamRepository;
import com.synectiks.exam.repository.StudentExamReportRepository;
import com.synectiks.exam.repository.AcademicExamSettingRepository;
import com.synectiks.exam.repository.TypeOfGradingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query  implements GraphQLQueryResolver {
    private final static Logger logger = LoggerFactory.getLogger(Query.class);

    private final AcademicExamSettingRepository academicExamSettingRepository;

    private final TypeOfGradingRepository typeOfGradingRepository;

    private final StudentExamReportRepository studentExamReportRepository;

    private final CompetitiveExamRepository competitiveExamRepository;


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



}
