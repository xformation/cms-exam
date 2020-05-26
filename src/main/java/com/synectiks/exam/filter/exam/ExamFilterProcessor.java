package com.synectiks.exam.filter.exam;

import com.synectiks.exam.business.service.ExamService;
import com.synectiks.exam.domain.vo.CmsAcademicExamSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamFilterProcessor {


    @Autowired
    private ExamService examService;

    public List<CmsAcademicExamSettingVo> searchAcademicExamSetting(Long departmentId, Long batchId, Long sectionId, Long subjectId, Long branchId, String semester, String examName){
        return examService.searchAcademicExamSetting(departmentId, batchId, sectionId, subjectId, branchId, semester, examName);

    }

    public List<CmsAcademicExamSettingVo> searchAcademicExamSetting(ExamListFilterInput filter){
        return examService.searchAcademicExamSetting(filter);
    }

}

