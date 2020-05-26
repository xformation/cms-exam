package com.synectiks.exam.graphql.types.AcademicExamSetting;

import com.synectiks.exam.domain.AcademicExamSetting;

import java.util.List;

public class RemoveAcademicExamSettingPayload {
    private final List<AcademicExamSetting> academicExamSettings;

    public List<AcademicExamSetting> getAcademicExamSettings(){
        return academicExamSettings;
    }

    public RemoveAcademicExamSettingPayload(List<AcademicExamSetting> academicExamSettings)
    {
        this.academicExamSettings = academicExamSettings;
    }
}
