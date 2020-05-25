package com.synectiks.exam.graphql.types.AcademicExamSetting;

import com.synectiks.exam.domain.AcademicExamSetting;

public class UpdateAcademicExamSettingPayload extends  AddAcademicExamSettingPayload{
    public  UpdateAcademicExamSettingPayload(AcademicExamSetting academicExamSetting)
    {
        super(academicExamSetting);
    }
}
