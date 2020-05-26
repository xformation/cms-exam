package com.synectiks.exam.business.service;

import com.synectiks.exam.constant.CmsConstants;
import com.synectiks.exam.domain.AcademicExamSetting;
import com.synectiks.exam.domain.vo.CmsAcademicExamSettingVo;
import com.synectiks.exam.filter.exam.ExamListFilterInput;
import com.synectiks.exam.repository.AcademicExamSettingRepository;
import com.synectiks.exam.service.util.CommonUtil;
import com.synectiks.exam.service.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ExamService {
    @Autowired
    AcademicExamSettingRepository academicExamSettingRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public List<CmsAcademicExamSettingVo> searchAcademicExamSetting(Long departmentId, Long batchId, Long sectionId, Long subjectId, Long branchId, String semester, String examName) {
        AcademicExamSetting acexm = new AcademicExamSetting();
        if (examName != null) {
            acexm.setExamName(examName);
        }
        if (departmentId != null) {
            acexm.setDepartmentId(departmentId);
        }
        if (batchId != null) {
            acexm.setBatchId(batchId);
        }
        if (sectionId != null) {
            acexm.setSectionId(sectionId);
        }
        if (branchId != null) {
            acexm.setBranchId(branchId);
        }
        if (subjectId != null) {
            acexm.setSubjectId(subjectId);
        }
        if(semester != null) {
            acexm.setSemester(semester);
        }
        Example<AcademicExamSetting> example = Example.of(acexm);
        List<AcademicExamSetting> list = this.academicExamSettingRepository.findAll(example);
        List<CmsAcademicExamSettingVo> ls = new ArrayList<>();
        for(AcademicExamSetting academicExamSetting: list) {
            CmsAcademicExamSettingVo vo = CommonUtil.createCopyProperties(academicExamSetting, CmsAcademicExamSettingVo.class);
            vo.setStrexamDate(DateFormatUtil.changeLocalDateFormat(academicExamSetting.getExamDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
            vo.setExamDate(null);
            ls.add(vo);
        }
        return ls;
    }
    public List<CmsAcademicExamSettingVo> searchAcademicExamSetting(ExamListFilterInput filter) {
        AcademicExamSetting academicExamSetting = new AcademicExamSetting();
        if (!CommonUtil.isNullOrEmpty(filter.getDepartmentId())) {
            academicExamSetting.setDepartmentId(Long.parseLong(filter.getDepartmentId()));
        }
        if (!CommonUtil.isNullOrEmpty(filter.getBatchId())) {
            academicExamSetting.setBatchId(Long.parseLong(filter.getBatchId()));
        }
        if (!CommonUtil.isNullOrEmpty(filter.getSectionId())) {
            academicExamSetting.setSectionId(Long.parseLong(filter.getSectionId()));
        }
        if (!CommonUtil.isNullOrEmpty(filter.getBranchId())) {
            academicExamSetting.setBranchId(Long.parseLong(filter.getBranchId()));
        }
        if (!CommonUtil.isNullOrEmpty(filter.getSubjectId())) {
            academicExamSetting.setSubjectId(Long.parseLong(filter.getSubjectId()));
        }
        Example<AcademicExamSetting> example = Example.of(academicExamSetting);
        List<AcademicExamSetting> list = this.academicExamSettingRepository.findAll(example);
        List<CmsAcademicExamSettingVo> ls = new ArrayList<>();
        for(AcademicExamSetting ae: list) {
            CmsAcademicExamSettingVo vo = CommonUtil.createCopyProperties(ae, CmsAcademicExamSettingVo.class);
            vo.setStrexamDate(DateFormatUtil.changeLocalDateFormat(ae.getExamDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
            vo.setExamDate(null);
            ls.add(vo);
        }
        return ls;
    }



    public List<CmsAcademicExamSettingVo> getAcademicList(){
        List<AcademicExamSetting> list = this.academicExamSettingRepository.findAll();
        List<CmsAcademicExamSettingVo> ls = changeAcademicSettingToCmsAcademicSettingList(list);
        Collections.sort(ls, (o1, o2) -> o2.getId().compareTo(o1.getId()));
        return ls;
    }
    private List<CmsAcademicExamSettingVo> changeAcademicSettingToCmsAcademicSettingList(List<AcademicExamSetting> list){
        List<CmsAcademicExamSettingVo> ls = new ArrayList<>();
        for(AcademicExamSetting ac: list) {
            CmsAcademicExamSettingVo vo = CommonUtil.createCopyProperties(ac, CmsAcademicExamSettingVo.class);
            convertDatesAndProvideDependencies(ac, vo);
            ls.add(vo);
        }
        return ls;
    }
    private void convertDatesAndProvideDependencies(AcademicExamSetting ac, CmsAcademicExamSettingVo vo) {
        if(ac.getExamDate() != null) {
            vo.setStrexamDate(DateFormatUtil.changeLocalDateFormat(ac.getExamDate(), CmsConstants.DATE_FORMAT_dd_MM_yyyy));
            vo.setExamDate(null);
        }
    }

}
